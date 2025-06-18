-- Clean existing data (order matters due to foreign keys)
DELETE FROM frescosG9.batch;
DELETE FROM frescosG9.inbound_order;
DELETE FROM frescosG9.product;
DELETE FROM frescosG9.seller;
DELETE FROM frescosG9.sector;
DELETE FROM frescosG9.warehouse_rep;
DELETE FROM frescosG9.warehouse;
DELETE FROM frescosG9.product_type;
DELETE FROM frescosG9.user_account;

-- Insert test data with schema prefix
INSERT INTO frescosG9.user_account (id, user_name, password) VALUES
                                                                 (1, 'rep_user', 'password123'),
                                                                 (2, 'seller_user', 'password456');

INSERT INTO frescosG9.warehouse (id, warehouse_code, name, location) VALUES
                                                                         (1, 1001, 'Test Warehouse', 'Test Location'),
                                                                         (2, 2002, 'Other Warehouse', 'Other Location');

INSERT INTO frescosG9.warehouse_rep (id, name, role, warehouse_id, user_id) VALUES
    (1, 'Test Representative', 'Manager', 1, 1);

INSERT INTO frescosG9.product_type (id, category, name, min_required_temp, max_required_temp) VALUES
                                                                                                  (1, 'FF', 'Fresh Food', 0.0, 10.0),
                                                                                                  (2, 'RF', 'Refrigerated', -5.0, 0.0);

INSERT INTO frescosG9.sector (id, sector_code, name, current_capacity, max_capacity, temp, warehouse_id, product_type_id) VALUES
                                                                                                                              (1, 101, 'Fresh Section', 0, 1000, 5.0, 1, 1),
                                                                                                                              (2, 102, 'Refrigerated Section', 0, 500, -2.0, 1, 2);

INSERT INTO frescosG9.seller (id, name, user_id) VALUES
    (1, 'Test Seller', 2);

INSERT INTO frescosG9.product (id, name, description, price, product_type_id, seller_id) VALUES
                                                                                             (1, 'Test Product 1', 'Test Description 1', 10.50, 1, 1),
                                                                                             (2, 'Test Product 2', 'Test Description 2', 15.75, 1, 1),
                                                                                             (3, 'Refrigerated Product', 'Cold Product', 20.00, 2, 1);