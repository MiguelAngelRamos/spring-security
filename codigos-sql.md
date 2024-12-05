```sql
-- https://github.com/spring-projects/spring-security/blob/main/core/src/main/resources/org/springframework/security/core/userdetails/jdbc/users.ddl

USE security_db;

-- Crear la tabla de usuarios
CREATE TABLE users (
    username VARCHAR(50) COLLATE utf8mb4_general_ci NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

-- Crear la tabla de authorities
CREATE TABLE authorities (
    username VARCHAR(50) COLLATE utf8mb4_general_ci NOT NULL,
    authority VARCHAR(50) COLLATE utf8mb4_general_ci NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
);

-- Crear índice único para evitar duplicados en authorities
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

INSERT INTO users (username, password, enabled) values ('super_user', 'academy', true), ('basic_user', 'academy', true);

INSERT INTO authorities (username, authority) values ('super_user', 'admin'),('basic_user','user');
```


## Personalizado

```sql

USE custom_security;

CREATE TABLE customers (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- ID autoincremental como clave primaria
    email VARCHAR(50) NOT NULL UNIQUE,            -- Campo único para el email
    password VARCHAR(500) NOT NULL,                    -- Contraseña encriptada
    role VARCHAR(20) NOT NULL                      -- Rol o autoridad del usuario
);

INSERT INTO customers (email, password, role ) values ('sofiadeveloper@correo.com', 'academy', 'admin'), ('catalinadeveloper@correo.com', 'academy', 'user');

select * from customers;


```