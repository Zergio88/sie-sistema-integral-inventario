-- ============================================================================
-- V2 MIGRATION: Users and basic traceability
-- ============================================================================
-- Purpose: Add authentication users and lightweight ownership tracking.
-- Scope: Minimal schema only. Audit log and stock tracking are deferred to
-- later migrations when those features are implemented in the application.
-- ============================================================================

-- ============================================================================
-- 1. USERS TABLE
-- ============================================================================
-- Stores system users for JWT authentication and role-based authorization.
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

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_active ON users(active);

-- ============================================================================
-- 2. DEVICE TRACEABILITY
-- ============================================================================
-- Adds lightweight ownership tracking for inventory items.
-- created_by identifies who registered the device.
-- updated_by identifies who last changed it.
-- ============================================================================
ALTER TABLE device
ADD COLUMN created_by INT REFERENCES users(id),
ADD COLUMN updated_by INT REFERENCES users(id);

CREATE INDEX idx_device_created_by ON device(created_by);
CREATE INDEX idx_device_updated_by ON device(updated_by);

-- ============================================================================
-- 3. SPARE_LOT TRACEABILITY
-- ============================================================================
-- Same lightweight ownership tracking for spare parts lots.
-- ============================================================================
ALTER TABLE spare_lot
ADD COLUMN created_by INT REFERENCES users(id),
ADD COLUMN updated_by INT REFERENCES users(id);

CREATE INDEX idx_spare_lot_created_by ON spare_lot(created_by);
CREATE INDEX idx_spare_lot_updated_by ON spare_lot(updated_by);

-- ============================================================================
-- END OF V2 MIGRATION
-- ============================================================================
