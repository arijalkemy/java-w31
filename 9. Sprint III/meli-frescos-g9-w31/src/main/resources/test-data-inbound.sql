-- Start with tables that have the most dependencies on other tables.
DELETE FROM frescosG9.purchase_order_item;
DELETE FROM frescosG9.shipment;
DELETE FROM frescosG9.batch;

-- Now delete the tables that the previous ones depended on.
DELETE FROM frescosG9.inbound_order;
DELETE FROM frescosG9.purchase_order;
DELETE FROM frescosG9.product;

-- Continue moving up the dependency chain.
DELETE FROM frescosG9.sector;
DELETE FROM frescosG9.warehouse_rep;
DELETE FROM frescosG9.seller;
DELETE FROM frescosG9.buyer;
DELETE FROM frescosG9.carrier;

-- Finally, delete the base tables that have no foreign keys to other tables.
DELETE FROM frescosG9.product_type;
DELETE FROM frescosG9.warehouse;
DELETE FROM frescosG9.user_account;

-- Reset sequence for H2/PostgreSQL
ALTER TABLE frescosG9.user_account ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.warehouse ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.warehouse_rep ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.product_type ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.sector ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.seller ALTER COLUMN id RESTART WITH 1;
ALTER TABLE frescosG9.product ALTER COLUMN id RESTART WITH 1;


-- Insert user accounts with roles
-- Note: Use a real BCrypt hash for passwords in a real app. Plain text is for example only.
INSERT INTO frescosG9.user_account (id, user_name, password, role)
VALUES (1, 'rep_user', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'WAREHOUSE_REP'), -- pw: password
       (2, 'seller_user', '$2a$10$dXJ3SWBRuKNtQO1p24T42uXm0p5b34h/A8x2i9M22G5a1T.g3O13q', 'SELLER'); -- pw: password

-- Insert warehouses
INSERT INTO frescosG9.warehouse (id, warehouse_code, name, location)
VALUES (1, 1001, 'Test Warehouse', 'Test Location'),
       (2, 2002, 'Other Warehouse', 'Other Location');

-- Insert representative and link to user_account and warehouse
INSERT INTO frescosG9.warehouse_rep (id, name, user_id, warehouse_id)
VALUES (1, 'Test Representative', 1, 1);

--
-- THIS IS THE CORRECTED LINE:
-- Insert product types with required temperature fields
INSERT INTO frescosG9.product_type (id, category, name, min_required_temp, max_required_temp)
VALUES (1, 'FF', 'Fresh Food', 0.0, 10.0),
       (2, 'RF', 'Refrigerated', -5.0, 0.0);
--
--

-- Insert sectors
INSERT INTO frescosG9.sector (id, sector_code, current_capacity, max_capacity, warehouse_id, product_type_id)
VALUES (1, 101, 0, 1000, 1, 1),
       (2, 102, 0, 500, 1, 2);

-- Insert seller
INSERT INTO frescosG9.seller (id, name, user_id)
VALUES (1, 'Test Seller', 2);

-- Insert products
INSERT INTO frescosG9.product (id, name, price, product_type_id, seller_id)
VALUES (1, 'Test Product 1', 10.50, 1, 1),
       (2, 'Test Product 2', 15.75, 1, 1),
       (3, 'Refrigerated Product', 20.00, 2, 1);