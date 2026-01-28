-- 1. Tabla Raíz: Tenants
CREATE TABLE tenants (
                         id BIGSERIAL PRIMARY KEY,
                         business_name VARCHAR(150) NOT NULL,
                         assignedURL VARCHAR(50) NOT NULL UNIQUE,
                         status BOOLEAN DEFAULT TRUE,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Configuración de Tenants (Relación 1:1)
CREATE TABLE tenant_configs (
                                id BIGSERIAL PRIMARY KEY,
                                tenant_id BIGINT NOT NULL UNIQUE,
                                primary_color VARCHAR(7),
                                logo_url VARCHAR(500), -- Aumentado para URLs largas
                                favicon_url VARCHAR(500),
                                welcome_message TEXT,
                                allows_cancelation BOOLEAN NOT NULL DEFAULT TRUE,
                                cancelation_max_hours INTEGER NOT NULL DEFAULT 24,
                                CONSTRAINT fk_config_tenant FOREIGN KEY (tenant_id) REFERENCES tenants(id) ON DELETE CASCADE
);

-- 3. Administradores (Relación N:1 con Tenant)
CREATE TABLE user_admins (
                             id BIGSERIAL PRIMARY KEY,
                             tenant_id BIGINT NOT NULL,
                             phone_number VARCHAR(20) NOT NULL,
                             password_hash VARCHAR(255) NOT NULL,
                             active BOOLEAN DEFAULT TRUE,
                             CONSTRAINT fk_admin_tenant FOREIGN KEY (tenant_id) REFERENCES tenants(id)
);

-- 4. Clientes (Relación N:1 con Tenant)
CREATE TABLE users_clients (
                               id BIGSERIAL PRIMARY KEY,
                               tenant_id BIGINT NOT NULL,
                               name VARCHAR(100) NOT NULL,
                               last_name VARCHAR(100) NOT NULL,
                               phone_number VARCHAR(20) NOT NULL,
                               password_hash VARCHAR(255) NOT NULL,
                               CONSTRAINT fk_client_tenant FOREIGN KEY (tenant_id) REFERENCES tenants(id)
);

-- 5. Tipos de Servicio
CREATE TABLE services (
                          id BIGSERIAL PRIMARY KEY,
                          tenant_id BIGINT NOT NULL,
                          name_service VARCHAR(100) NOT NULL,
                          description_service VARCHAR(500),
                          price DECIMAL(19, 4) NOT NULL,
                          duration_minutes INTEGER NOT NULL,
                          active BOOLEAN NOT NULL DEFAULT TRUE,
                          CONSTRAINT fk_service_tenant FOREIGN KEY (tenant_id) REFERENCES tenants(id)
);

-- 6. Empleados
CREATE TABLE employees (
                           id BIGSERIAL PRIMARY KEY,
                           tenant_id BIGINT NOT NULL,
                           name VARCHAR(100) NOT NULL,
                           last_name VARCHAR(100) NOT NULL,
                           phone_number VARCHAR(20),
                           status BOOLEAN NOT NULL DEFAULT TRUE,
                           CONSTRAINT fk_employee_tenant FOREIGN KEY (tenant_id) REFERENCES tenants(id)
);

-- 7. Tabla Intermedia: Empleados y Servicios (CORREGIDA)
CREATE TABLE employee_services (
                                   employee_id BIGINT NOT NULL, -- Antes tenías 'id' aquí, pero referenciabas 'employee_id' abajo
                                   service_id BIGINT NOT NULL,
                                   PRIMARY KEY (employee_id, service_id),
                                   CONSTRAINT fk_rel_employee FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE,
                                   CONSTRAINT fk_rel_service FOREIGN KEY (service_id) REFERENCES services(id) ON DELETE CASCADE
);

-- 8. Bookings (Citas)
CREATE TABLE bookings (
                          id BIGSERIAL PRIMARY KEY,
                          tenant_id BIGINT NOT NULL,
                          client_id BIGINT NOT NULL,
                          service_id BIGINT NOT NULL, -- Cambiado de service_type_id a service_id para rigor con la tabla 'services'
                          employee_id BIGINT NOT NULL,
                          start_booking TIMESTAMP NOT NULL,
                          end_booking TIMESTAMP NOT NULL,
                          booking_state VARCHAR(50) NOT NULL,
                          CONSTRAINT fk_booking_tenant FOREIGN KEY (tenant_id) REFERENCES tenants(id),
                          CONSTRAINT fk_booking_client FOREIGN KEY (client_id) REFERENCES users_clients(id),
                          CONSTRAINT fk_booking_service FOREIGN KEY (service_id) REFERENCES services(id),
                          CONSTRAINT fk_booking_employee FOREIGN KEY (employee_id) REFERENCES employees(id)
);