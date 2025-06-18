-- Start with tables that have the most dependencies on other tables.
DELETE
FROM frescosG9.purchase_order_item;
DELETE
FROM frescosG9.shipment;
DELETE
FROM frescosG9.batch;

-- Now delete the tables that the previous ones depended on.
DELETE
FROM frescosG9.inbound_order;
DELETE
FROM frescosG9.purchase_order;
DELETE
FROM frescosG9.product;

-- Continue moving up the dependency chain.
DELETE
FROM frescosG9.sector;
DELETE
FROM frescosG9.warehouse_rep;
DELETE
FROM frescosG9.seller;
DELETE
FROM frescosG9.buyer;
DELETE
FROM frescosG9.carrier;

-- Finally, delete the base tables that have no foreign keys to other tables.
DELETE
FROM frescosG9.product_type;
DELETE
FROM frescosG9.warehouse;
DELETE
FROM frescosG9.user_account;


ALTER TABLE frescosG9.user_account
    ALTER COLUMN id RESTART WITH 1;

-- =========================
-- User Accounts (Corrected with Roles)
-- =========================
-- Add the 'role' column to your INSERT statement
INSERT INTO frescosG9.user_account (id, user_name, password, role)
VALUES (1, 'analopez', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'WAREHOUSE_REP'), -- pw: password
       (2, 'jperez', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'BUYER'),           -- pw: password
       (3, 'valesosa', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'BUYER'),         -- pw: password
       (4, 'superlaesq', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'SELLER'),      -- pw: password
       (5, 'distsur', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'SELLER'),         -- pw: password
       (6, 'alimentoscampo', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'SELLER'),  -- pw: password
       (7, 'cmendez', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'WAREHOUSE_REP'),  -- pw: password
       (8, 'mvazquez', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'WAREHOUSE_REP');
-- pw: password

-- =========================
-- Product Types
-- =========================
INSERT INTO frescosG9.product_type (id, category, name, min_required_temp, max_required_temp)
VALUES (1, 'FS', 'Fresco', 1.0, 7.0),
       (2, 'RF', 'Refrigerado', -2.0, 4.0),
       (3, 'FF', 'Congelado', -25.0, -18.0);

-- =========================
-- Warehouses
-- =========================
INSERT INTO frescosG9.warehouse (id, warehouse_code, name, location)
VALUES (1, 101, 'Depósito CABA', 'Av. Rivadavia 5000, CABA'),
       (2, 102, 'Depósito GBA', 'Ruta 8 km 45, Pilar, BA'),
       (3, 103, 'Depósito Córdoba', 'Av. Colón 2100, Córdoba Capital');

-- =========================
-- Warehouse Representatives (Correctly linked to user_account)
-- =========================
INSERT INTO frescosG9.warehouse_rep (id, user_id, name, role, warehouse_id)
VALUES (1, 1, 'Ana López', 'Supervisor', 1),
       (2, 7, 'Carlos Méndez', 'Jefe de turno', 2),
       (3, 8, 'Miguel Vázquez', 'Encargado', 3);

-- =========================
-- Sectors (3 por warehouse: 1 de cada tipo)
-- =========================
-- CABA
INSERT INTO frescosG9.sector (id, product_type_id, sector_code, name, max_capacity, temp, warehouse_id)
VALUES (1, 1, 1001, 'Frescos Norte CABA', 100, 4.0, 1),
       (2, 2, 1002, 'Refrigerados Este CABA', 80, 2.0, 1),
       (3, 3, 1003, 'Congelados Sur CABA', 70, -20.0, 1);
-- GBA
INSERT INTO frescosG9.sector (id, product_type_id, sector_code, name, max_capacity, temp, warehouse_id)
VALUES (4, 1, 2001, 'Frescos Norte GBA', 120, 5.0, 2),
       (5, 2, 2002, 'Refrigerados Oeste GBA', 90, 2.0, 2),
       (6, 3, 2003, 'Congelados Este GBA', 80, -22.0, 2);
-- Córdoba
INSERT INTO frescosG9.sector (id, product_type_id, sector_code, name, max_capacity, temp, warehouse_id)
VALUES (7, 1, 3001, 'Frescos Centro CBA', 110, 6.0, 3),
       (8, 2, 3002, 'Refrigerados Central CBA', 85, 3.0, 3),
       (9, 3, 3003, 'Congelados Central CBA', 75, -19.0, 3);


-- =========================
-- Sellers
-- =========================
INSERT INTO frescosG9.seller (id, name, user_id)
VALUES (1, 'Supermercado La Esquina', 4),
       (2, 'Distribuidora Sur', 5),
       (3, 'Alimentos del Campo', 6);

-- =========================
-- Products
-- =========================
INSERT INTO frescosG9.product (id, name, description, price, product_type_id, seller_id)
VALUES (1, 'Lechuga fresca', 'Lechuga recién cosechada', 150.00, 1, 3),
       (2, 'Lechuga casifresca', 'Lechuga casirecién cosechada', 150.00, 1, 3),
       (3, 'Yogur natural', 'Yogur descremado 1L', 220.00, 2, 1),
       (4, 'Filet de merluza congelado', 'Envase 1kg', 600.00, 3, 2);

-- =========================
-- Inbound Orders
-- =========================
INSERT INTO frescosG9.inbound_order (id, order_number, order_date, rep_id, warehouse_id)
VALUES (1, 1001, '2025-05-10', 1, 1),
       (2, 1002, '2025-05-12', 2, 2),
       (3, 1003, '2025-05-14', 3, 3);

-- =========================
-- Batch (with unique batch_number)
-- =========================
-- CABA - Fresco
INSERT INTO frescosG9.batch (id, batch_number, initial_quantity, actual_quantity, manufacturing_datetime, expire_date,
                             registration_temp, minimum_temp, product_id, sector_id, inbound_order_id)
VALUES (1, 101, 50, 48, '2025-05-09 07:00:00', '2025-07-01', 5.0, 1.0, 1, 1, 1),
       (2, 102, 80, 75, '2025-05-11 08:00:00', '2025-06-23', 5.0, 1.0, 2, 1, 1);
-- Unique batch_number
-- GBA - Refrigerado
INSERT INTO frescosG9.batch (id, batch_number, initial_quantity, actual_quantity, manufacturing_datetime, expire_date,
                             registration_temp, minimum_temp, product_id, sector_id, inbound_order_id)
VALUES (3, 103, 80, 75, '2025-05-11 08:00:00', '2025-06-23', 2.0, -2.0, 3, 5, 2);
-- Córdoba - Congelado
INSERT INTO frescosG9.batch (id, batch_number, initial_quantity, actual_quantity, manufacturing_datetime, expire_date,
                             registration_temp, minimum_temp, product_id, sector_id, inbound_order_id)
VALUES (4, 104, 60, 60, '2025-05-13 06:30:00', '2025-12-01', -20.0, -25.0, 4, 9, 3);