-- 1. Actualización de USER_ADMINS
-- Añadimos campos que faltaban en el SQL original según la entidad Java
ALTER TABLE user_admins ADD COLUMN user_position VARCHAR(30) NOT NULL;
ALTER TABLE user_admins ADD COLUMN name VARCHAR(100) NOT NULL;
ALTER TABLE user_admins ADD COLUMN last_name VARCHAR(100) NOT NULL;
ALTER TABLE user_admins ADD COLUMN email VARCHAR(100) NOT NULL;

-- Aseguramos restricciones de unicidad para login profesional
ALTER TABLE user_admins ADD CONSTRAINT uk_admin_email UNIQUE (email);
ALTER TABLE user_admins ADD CONSTRAINT uk_admin_phone UNIQUE (phone_number);


-- 2. Actualización de EMPLOYEES
-- Faltaban el email y el hash de contraseña en el SQL original
ALTER TABLE employees ADD COLUMN email VARCHAR(100) NOT NULL;
ALTER TABLE employees ADD COLUMN password_hash VARCHAR(255) NOT NULL;

-- Aseguramos que el email y teléfono sean únicos para evitar duplicados en login
ALTER TABLE employees ADD CONSTRAINT uk_employee_email UNIQUE (email);
ALTER TABLE employees ADD CONSTRAINT uk_employee_phone UNIQUE (phone_number);


-- 3. Actualización de USERS_CLIENTS
-- Corregimos el nombre de la columna para que coincida con @Column(name = "password_hash")
ALTER TABLE users_clients RENAME COLUMN password_hash TO password_hash_old; -- Por seguridad si hubiera datos
ALTER TABLE users_clients ADD COLUMN password_hash VARCHAR(255) NOT NULL;
-- (Si es una base de datos nueva, simplemente podrías haber hecho un ALTER COLUMN)


-- 4. Actualización de TENANT_CONFIGS
-- Corregimos el error tipográfico del SQL original (cancelation -> cancellation) para que coincida con Java
ALTER TABLE tenant_configs RENAME COLUMN allows_cancelation TO allows_cancellation;
ALTER TABLE tenant_configs RENAME COLUMN cancelation_max_hours TO cancellation_max_hours;


-- 5. Restricciones Multi-tenant (Rigor de Integridad)
-- Un cliente no debería repetirse dentro del mismo negocio
ALTER TABLE users_clients ADD CONSTRAINT uk_tenant_client_phone UNIQUE (tenant_id, phone_number);

-- Un servicio no debería tener el mismo nombre dentro del mismo negocio
ALTER TABLE services ADD CONSTRAINT uk_tenant_service_name UNIQUE (tenant_id, name_service);