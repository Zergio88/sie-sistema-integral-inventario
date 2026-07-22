-- Index for serial number lookup by value (most frequent query in the system)
CREATE INDEX IF NOT EXISTS idx_serial_number_value ON serial_number(value);

-- Index for device lookup by status
CREATE INDEX IF NOT EXISTS idx_device_status ON device(status);

-- Index for device lookup by pallet
CREATE INDEX IF NOT EXISTS idx_device_pallet_id ON device(pallet_id);

-- Index for spare lot lookup by status
CREATE INDEX IF NOT EXISTS idx_spare_lot_status ON spare_lot(status);