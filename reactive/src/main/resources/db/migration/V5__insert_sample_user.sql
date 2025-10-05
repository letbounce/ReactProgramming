-- Insert a sample user and grant ROLE_User

-- ensure role exists
INSERT INTO roles (name)
SELECT 'ROLE_User'
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE name = 'ROLE_User');

-- insert user if not exists (NoOp encoder -> plain text password)
INSERT INTO users (username, password)
SELECT 'student', 'student'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'student');

-- link user to role if not already linked
WITH u AS (
    SELECT id FROM users WHERE username = 'student'
), r AS (
    SELECT id FROM roles WHERE name = 'ROLE_User'
)
INSERT INTO roles_has_users (user_id, role_id)
SELECT u.id, r.id FROM u, r
WHERE NOT EXISTS (
    SELECT 1 FROM roles_has_users WHERE user_id = u.id AND role_id = r.id
);


