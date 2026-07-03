-- ============================================================================
-- V2 MIGRATION: Authentication, Audit Logging & Stock Tracking Schema
-- ============================================================================
-- Purpose: Add authentication layer, audit trail, and stock tracking sessions
-- Date: 2026-06-29
-- ============================================================================

-- ============================================================================
-- 1. USERS TABLE
-- ============================================================================
-- Stores system users with authentication credentials and role-based access
-- 
-- Fields:
--   id: Primary key (auto-increment)
--   email: Unique identifier for login (UNIQUE constraint)
--   password_hash: Bcrypt hashed password (NEVER store plaintext)
--   role: Authorization level - ADMIN (full access) or OPERATOR (limited)
--   active: Soft-delete flag (false = deactivated, true = active)
--   created_at: Timestamp when user was created
--   updated_at: Timestamp of last modification (password change, profile update, etc)
--
-- Why:
--   - JWT authentication requires user identity
--   - Roles enable access control (authorization)
--   - active flag allows deactivation without data deletion (audit trail)
--   - created_at/updated_at track lifecycle
-- ============================================================================
CREATE TABLE users (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'OPERATOR' CHECK (role IN ('ADMIN', 'OPERATOR')),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Index on email for faster login queries
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_active ON users(active);

-- ============================================================================
-- 2. AUDIT_LOG TABLE
-- ============================================================================
-- Maintains complete audit trail of all data modifications
-- Enables regulatory compliance, debugging, and forensic analysis
--
-- Fields:
--   id: Primary key (auto-increment)
--   table_name: Name of table being modified (device, spare_lot, etc)
--   operation: Type of change - INSERT, UPDATE, or DELETE
--   user_id: FK to users table (WHO made the change)
--   old_values: JSONB snapshot of row BEFORE modification (NULL for INSERT)
--   new_values: JSONB snapshot of row AFTER modification (NULL for DELETE)
--   timestamp: When the change occurred
--
-- Why:
--   - Regulatory/compliance: Prove WHO changed WHAT and WHEN
--   - Debugging: Trace data issues to specific operations
--   - Forensics: Reconstruct state at any point in time
--   - JSONB allows flexible schema (any column can be tracked)
--
-- Example audit entry:
--   table_name='device', operation='UPDATE', user_id=1
--   old_values={'status':'available', 'location_id':5}
--   new_values={'status':'lost', 'location_id':NULL}
--   timestamp=2026-06-29 22:15:00
--   → Interpretation: Admin 1 marked Device as lost at 22:15
-- ============================================================================
CREATE TABLE audit_log (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    table_name VARCHAR(50) NOT NULL,
    operation VARCHAR(10) NOT NULL CHECK (operation IN ('INSERT', 'UPDATE', 'DELETE')),
    user_id INT NOT NULL REFERENCES users(id),
    old_values JSONB,
    new_values JSONB,
    timestamp TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Indexes for efficient audit queries
CREATE INDEX idx_audit_log_table_name ON audit_log(table_name);
CREATE INDEX idx_audit_log_user_id ON audit_log(user_id);
CREATE INDEX idx_audit_log_timestamp ON audit_log(timestamp);
CREATE INDEX idx_audit_log_operation ON audit_log(operation);

-- ============================================================================
-- 3. STOCK_TRACKING_SESSION TABLE
-- ============================================================================
-- Represents a physical inventory counting session
-- Used in stock taking workflow: start session → scan devices → close → compare
--
-- Fields:
--   id: Primary key (auto-increment)
--   zone_id: FK to zone table (WHICH zone is being counted)
--   scope: Granularity level - 'ZONE', 'SECTOR', or 'WAREHOUSE'
--   status: Lifecycle state - OPEN (counting in progress) or CLOSED (completed)
--   started_at: When counting session began
--   ended_at: When counting session was closed (NULL while open)
--
-- Why:
--   - Track ongoing inventory sessions
--   - Link scanned devices to specific session
--   - Calculate discrepancies: system inventory vs physical count
--
-- Workflow:
--   1. Admin starts session in Zone A at 10:00 (status='OPEN', started_at=10:00)
--   2. Operators scan all devices in that zone
--   3. Admin closes session at 12:00 (status='CLOSED', ended_at=12:00)
--   4. System compares scanned devices vs DB records for discrepancies
-- ============================================================================
CREATE TABLE stock_tracking_session (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    zone_id INT NOT NULL REFERENCES zone(id),
    scope VARCHAR(50) NOT NULL DEFAULT 'ZONE' CHECK (scope IN ('ZONE', 'SECTOR', 'WAREHOUSE')),
    status VARCHAR(20) NOT NULL DEFAULT 'OPEN' CHECK (status IN ('OPEN', 'CLOSED')),
    started_at TIMESTAMP NOT NULL DEFAULT NOW(),
    ended_at TIMESTAMP
);

-- Indexes for session lookups
CREATE INDEX idx_stock_tracking_session_zone_id ON stock_tracking_session(zone_id);
CREATE INDEX idx_stock_tracking_session_status ON stock_tracking_session(status);

-- ============================================================================
-- 4. ALTER DEVICE TABLE
-- ============================================================================
-- Add traceability fields: WHO registered and WHEN
-- Tracks: created_by (who added to system) and scanned_by (who moved/verified)
--
-- New fields:
--   created_by: FK to users (admin/operator who registered the device)
--   scanned_by: FK to users (last person who scanned/verified the device)
--   scanned_at: TIMESTAMP of last scan (for "freshness" of data)
--
-- Why:
--   - Accountability: Know who registered each device
--   - Audit trail: Track movement history per device
--   - Verification: See if data is recent or stale (scanned_at)
--
-- Example queries enabled:
--   - "Which devices did Operator X scan on 2026-06-29?"
--   - "Find devices not scanned in last 30 days" (stale inventory)
--   - "Who registered this device?"
-- ============================================================================
ALTER TABLE device
ADD COLUMN created_by INT REFERENCES users(id),
ADD COLUMN scanned_by INT REFERENCES users(id),
ADD COLUMN scanned_at TIMESTAMP;

CREATE INDEX idx_device_created_by ON device(created_by);
CREATE INDEX idx_device_scanned_by ON device(scanned_by);
CREATE INDEX idx_device_scanned_at ON device(scanned_at);

-- ============================================================================
-- 5. ALTER SPARE_LOT TABLE
-- ============================================================================
-- Add same traceability as DEVICE (repurposed lots also need audit trail)
-- Spare lots = spare parts boxes without individual serial numbers
-- Examples: box of 500 CPUs, case of keyboard replacements, etc
--
-- New fields:
--   created_by: FK to users (who registered this lot)
--   scanned_by: FK to users (last person who handled/verified)
--   scanned_at: TIMESTAMP of last operation
--
-- Why:
--   - Same accountability as devices
--   - Track lot movements (opened box on date X, picked items on date Y)
--   - Inventory aging (find old lots not touched in months)
-- ============================================================================
ALTER TABLE spare_lot
ADD COLUMN created_by INT REFERENCES users(id),
ADD COLUMN scanned_by INT REFERENCES users(id),
ADD COLUMN scanned_at TIMESTAMP;

CREATE INDEX idx_spare_lot_created_by ON spare_lot(created_by);
CREATE INDEX idx_spare_lot_scanned_by ON spare_lot(scanned_by);
CREATE INDEX idx_spare_lot_scanned_at ON spare_lot(scanned_at);

-- ============================================================================
-- END OF V2 MIGRATION
-- ============================================================================
-- Summary of changes:
--   ✓ users: 7 columns, 2 indexes (auth + active status)
--   ✓ audit_log: 7 columns, 4 indexes (compliance tracking)
--   ✓ stock_tracking_session: 5 columns, 2 indexes (inventory sessions)
--   ✓ device: +3 columns, +3 indexes (traceability)
--   ✓ spare_lot: +3 columns, +3 indexes (traceability)
--
-- Total: 2 new tables, 2 modified tables, 11 new indexes
-- Ready for: JWT authentication, Spring Security, audit logging triggers
-- ============================================================================
