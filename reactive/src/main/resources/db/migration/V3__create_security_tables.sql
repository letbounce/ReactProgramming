-- Create security-related tables: users, roles, roles_has_users

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS roles_has_users (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    role_id BIGINT
);

-- Ensure constraints are created (drop if exist, then add)
ALTER TABLE roles_has_users
    DROP CONSTRAINT IF EXISTS fk_user_id;
ALTER TABLE roles_has_users
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE roles_has_users
    DROP CONSTRAINT IF EXISTS fk_role_id;
ALTER TABLE roles_has_users
    ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles(id);


