DELETE FROM frescosG9.batch;
DELETE FROM frescosG9.inbound_order;
DELETE FROM frescosG9.product;
DELETE FROM frescosG9.seller;
DELETE FROM frescosG9.sector;
DELETE FROM frescosG9.warehouse_rep;
DELETE FROM frescosG9.warehouse;
DELETE FROM frescosG9.product_type;
DELETE FROM frescosG9.user_account;

-- user_account (máximo id: 2)
INSERT INTO frescosG9.user_account (id, user_name, password) VALUES
                                                                 (1, 'rep_user', 'password123'),
                                                                 (2, 'seller_user', 'password456');
ALTER TABLE frescosG9.user_account ALTER COLUMN id RESTART WITH 3;

-- warehouse (máximo id: 2)
INSERT INTO frescosG9.warehouse (id, warehouse_code, name, location) VALUES
                                                                         (1, 1001, 'Test Warehouse', 'Test Location'),
                                                                         (2, 2002, 'Other Warehouse', 'Other Location');
ALTER TABLE frescosG9.warehouse ALTER COLUMN id RESTART WITH 3;

-- warehouse_rep (máximo id: 1)
INSERT INTO frescosG9.warehouse_rep (id, name, role, warehouse_id, user_id) VALUES
    (1, 'Test Representative', 'Manager', 1, 1);
ALTER TABLE frescosG9.warehouse_rep ALTER COLUMN id RESTART WITH 2;

-- product_type (máximo id: 2)
INSERT INTO frescosG9.product_type (id, category, name, min_required_temp, max_required_temp) VALUES
                                                                                                  (1, 'FF', 'Fresh Food', 0.0, 10.0),
                                                                                                  (2, 'RF', 'Refrigerated', -5.0, 0.0);
ALTER TABLE frescosG9.product_type ALTER COLUMN id RESTART WITH 3;

-- sector (máximo id: 2)
INSERT INTO frescosG9.sector (id, sector_code, name, current_capacity, max_capacity, temp, warehouse_id, product_type_id) VALUES
                                                                                                                              (1, 101, 'Fresh Section', 0, 1000, 5.0, 1, 1),
                                                                                                                              (2, 102, 'Refrigerated Section', 0, 500, -2.0, 1, 2);
ALTER TABLE frescosG9.sector ALTER COLUMN id RESTART WITH 3;

-- seller (máximo id: 1)
INSERT INTO frescosG9.seller (id, name, user_id) VALUES
    (1, 'Test Seller', 2);
ALTER TABLE frescosG9.seller ALTER COLUMN id RESTART WITH 2;

-- product (máximo id: 3)
INSERT INTO frescosG9.product (id, name, description, price, product_type_id, seller_id) VALUES
                                                                                             (1, 'Test Product 1', 'Test Description 1', 10.50, 1, 1),
                                                                                             (2, 'Test Product 2', 'Test Description 2', 15.75, 1, 1),
                                                                                             (3, 'Refrigerated Product', 'Cold Product', 20.00, 2, 1);
ALTER TABLE frescosG9.product ALTER COLUMN id RESTART WITH 4;

-- inbound_order (máximo id: 1)
INSERT INTO frescosG9.inbound_order (id, order_number, order_date, rep_id, warehouse_id) VALUES
    (1, 5555, '2024-05-05', 1, 1);
ALTER TABLE frescosG9.inbound_order ALTER COLUMN id RESTART WITH 2;

-- batch (máximo id: 8)
INSERT INTO frescosG9.batch (id, batch_number, initial_quantity, actual_quantity, manufacturing_datetime, expire_date, registration_temp, minimum_temp, product_id, sector_id, inbound_order_id) VALUES
                                                                                                                                                                                                     (1, 48, 101, 50, '2024-05-09T07:00:00Z', '2024-07-01', 1.0, 5.0, 1, 1, 1),
                                                                                                                                                                                                     (2, 75, 102, 80, '2024-05-11T08:00:00Z', '2024-06-23', -2.0, 2.0, 2, 2, 1),
                                                                                                                                                                                                     (3, 60, 103, 60, '2024-05-13T06:30:00Z', '2024-12-01', -25.0, -20.0, 3, 2, 1),
                                                                                                                                                                                                     (4, 34, 106, 35, '2024-06-15T06:15:00Z', '2024-07-27', 1.0, 4.8, 1, 1, 1),
                                                                                                                                                                                                     (5, 38, 105, 40, '2024-06-10T05:30:00Z', '2024-07-25', 1.0, 5.1, 1, 1, 1),
                                                                                                                                                                                                     (6, 30, 104, 30, '2024-06-01T09:00:00Z', '2024-07-20', 1.0, 4.5, 1, 1, 1),
                                                                                                                                                                                                     (7, 70, 108, 70, '2024-06-14T08:10:00Z', '2024-07-21', -2.0, 2.1, 2, 2, 1),
                                                                                                                                                                                                     (8, 55, 107, 55, '2024-06-05T08:00:00Z', '2024-07-15', -2.0, 2.4, 2, 2, 1);
ALTER TABLE frescosG9.batch ALTER COLUMN id RESTART WITH 9;