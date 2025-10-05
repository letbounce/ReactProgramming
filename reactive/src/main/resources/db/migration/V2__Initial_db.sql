-- V2: Autobase schema based on entities

CREATE TABLE IF NOT EXISTS drivers (
    id              BIGSERIAL PRIMARY KEY,
    first_name      VARCHAR(100) NOT NULL,
    last_name       VARCHAR(100) NOT NULL,
    license_number  VARCHAR(64)  NOT NULL UNIQUE,
    assigned_car_id BIGINT
);

CREATE TABLE IF NOT EXISTS cars (
    id                   BIGSERIAL PRIMARY KEY,
    make                 VARCHAR(100) NOT NULL,
    model                VARCHAR(100) NOT NULL,
    registration_number  VARCHAR(32)  NOT NULL UNIQUE,
    vehicle_type         VARCHAR(32)  NOT NULL,
    capacity_kg          INTEGER      NOT NULL,
    serviceable          BOOLEAN      NOT NULL DEFAULT TRUE
);

ALTER TABLE drivers
    ADD CONSTRAINT fk_drivers_car
    FOREIGN KEY (assigned_car_id) REFERENCES cars(id);

CREATE TABLE IF NOT EXISTS trip_requests (
    id                    BIGSERIAL PRIMARY KEY,
    required_vehicle_type VARCHAR(32)  NOT NULL,
    required_capacity_kg  INTEGER      NOT NULL,
    route                 VARCHAR(255) NOT NULL,
    requested_at          TIMESTAMP    NOT NULL,
    status                VARCHAR(32)  NOT NULL
);

CREATE TABLE IF NOT EXISTS trips (
    id              BIGSERIAL PRIMARY KEY,
    request_id      BIGINT       NOT NULL,
    driver_id       BIGINT       NOT NULL,
    car_id          BIGINT       NOT NULL,
    assigned_at     TIMESTAMP    NOT NULL,
    started_at      TIMESTAMP,
    completed_at    TIMESTAMP,
    car_condition   VARCHAR(32),
    CONSTRAINT fk_trips_request FOREIGN KEY (request_id) REFERENCES trip_requests(id),
    CONSTRAINT fk_trips_driver  FOREIGN KEY (driver_id)  REFERENCES drivers(id),
    CONSTRAINT fk_trips_car     FOREIGN KEY (car_id)     REFERENCES cars(id)
);

CREATE INDEX IF NOT EXISTS idx_cars_registration ON cars(registration_number);
CREATE INDEX IF NOT EXISTS idx_requests_status ON trip_requests(status);
CREATE INDEX IF NOT EXISTS idx_trips_driver ON trips(driver_id);

