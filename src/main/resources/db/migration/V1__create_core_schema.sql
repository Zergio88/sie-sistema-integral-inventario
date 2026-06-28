CREATE TABLE zone (
                      id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      description TEXT
);

CREATE TABLE device_type (
                             id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             brand VARCHAR(100),
                             model VARCHAR(100),
                             category VARCHAR(50) NOT NULL,
                             description TEXT,
                             created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                             updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE location (
                          id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          zone_id INT NOT NULL REFERENCES zone(id),
                          name VARCHAR(100) NOT NULL,
                          location_type VARCHAR(50) NOT NULL,
                          notes TEXT
);

CREATE TABLE pallet (
                        id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        location_id INT NOT NULL REFERENCES location(id),
                        code VARCHAR(50) NOT NULL UNIQUE,
                        max_floors INT NOT NULL DEFAULT 1,
                        notes TEXT,
                        created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                        updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE device (
                        id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        device_type_id INT NOT NULL REFERENCES device_type(id),
                        pallet_id INT NOT NULL REFERENCES pallet(id),
                        floor_number INT NOT NULL DEFAULT 1,
                        status VARCHAR(50) NOT NULL DEFAULT 'available',
                        notes TEXT,
                        created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                        updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE serial_number (
                               id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                               device_id INT NOT NULL REFERENCES device(id),
                               value VARCHAR(100) NOT NULL,
                               source VARCHAR(50) NOT NULL,
                               is_primary BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE spare_lot (
                           id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                           device_type_id INT NOT NULL REFERENCES device_type(id),
                           location_id INT NOT NULL REFERENCES location(id),
                           quantity INT NOT NULL DEFAULT 0,
                           unit VARCHAR(50) NOT NULL,
                           status VARCHAR(50) NOT NULL DEFAULT 'available',
                           notes TEXT,
                           created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                           updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);