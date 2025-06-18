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

-- The root "parent" of many tables

-- Step 2: Reset table ID sequences
ALTER TABLE frescosG9.user_account
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.warehouse
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.product_type
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.seller
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.buyer
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.sector
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.product
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.inbound_order
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.batch
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.warehouse_rep
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.carrier
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.shipment
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.purchase_order
    ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.purchase_order_item
    ALTER COLUMN id RESTART WITH 1;


-- Step 3: Insert test data
-- Insert Users with correct roles
INSERT INTO frescosG9.user_account (id, user_name, password, role)
VALUES (1, 'rep_user', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'WAREHOUSE_REP'), -- pw: password
       (2, 'testbuyer', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'BUYER'),        -- pw: password
       (3, 'testseller', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'SELLER');
-- pw: password

-- Insert a Buyer
INSERT INTO frescosG9.buyer (id, user_id, name)
VALUES (1, 2, 'Test Buyer');

-- Insert a Seller
INSERT INTO frescosG9.seller (id, user_id, name)
VALUES (1, 3, 'Test Seller');

-- Insert Warehouses
INSERT INTO frescosG9.warehouse (id, warehouse_code, name, location)
VALUES (1, 1001, 'Test Warehouse', 'Test Location');

-- Insert a Warehouse Representative
INSERT INTO frescosG9.warehouse_rep (id, user_id, name, warehouse_id)
VALUES (1, 1, 'Test Representative', 1);

-- Insert Product Types
INSERT INTO frescosG9.product_type (id, category, name, min_required_temp, max_required_temp)
VALUES (1, 'FF', 'Fresh Food', 0.0, 10.0);

-- Insert Sectors
INSERT INTO frescosG9.sector (id, sector_code, current_capacity, max_capacity, warehouse_id, product_type_id)
VALUES (1, 101, 0, 1000, 1, 1);

-- Insert Products
INSERT INTO frescosG9.product (id, name, price, product_type_id, seller_id)
VALUES (1, 'Test Product 1', 10.50, 1, 1);

-- Insert an Inbound Order
INSERT INTO frescosG9.inbound_order (id, order_number, order_date, rep_id, warehouse_id)
VALUES (1, 5555, '2025-06-10', 1, 1);

-- Insert Batches for the product
INSERT INTO frescosG9.batch (id, batch_number, initial_quantity, actual_quantity, manufacturing_datetime, expire_date,
                             registration_temp, minimum_temp, product_id, sector_id, inbound_order_id)
VALUES (1, 48, 100, 50, '2025-05-09 07:00:00', '2025-07-01', 5.0, 1.0, 1, 1, 1),
       (2, 30, 100, 30, '2025-06-01 09:00:00', '2025-07-20', 4.5, 1.0, 1, 1, 1);