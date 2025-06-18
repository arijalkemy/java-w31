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

-- Insert test data with schema prefix
INSERT INTO frescosG9.user_account (user_name, password)
VALUES ('rep_user', 'password123'),
       ('seller_user', 'password456');

INSERT INTO frescosG9.warehouse (id, warehouse_code, name, location)
VALUES (1, 1001, 'Test Warehouse', 'Test Location'),
       (2, 2002, 'Other Warehouse', 'Other Location');

INSERT INTO frescosG9.warehouse_rep (id, name, role, warehouse_id, user_id)
VALUES (1, 'Test Representative', 'Manager', 1, 1);

INSERT INTO frescosG9.product_type (id, category, name, min_required_temp, max_required_temp)
VALUES (1, 'FF', 'Fresh Food', 0.0, 10.0),
       (2, 'RF', 'Refrigerated', -5.0, 0.0);

INSERT INTO frescosG9.sector (id, sector_code, name, current_capacity, max_capacity, temp, warehouse_id,
                              product_type_id)
VALUES (1, 101, 'Fresh Section', 0, 1000, 5.0, 1, 1),
       (2, 102, 'Refrigerated Section', 0, 500, -2.0, 1, 2);

INSERT INTO frescosG9.seller (id, name, user_id)
VALUES (1, 'Test Seller', 2);

INSERT INTO frescosG9.product (id, name, description, price, product_type_id, seller_id)
VALUES (1, 'Test Product 1', 'Test Description 1', 10.50, 1, 1),
       (2, 'Test Product 2', 'Test Description 2', 15.75, 1, 1),
       (3, 'Refrigerated Product', 'Cold Product', 20.00, 2, 1);

INSERT INTO frescosG9.inbound_order (order_number, order_date, rep_id, warehouse_id)
VALUES (1001, '2024-05-10',
        (SELECT id FROM frescosG9.warehouse_rep WHERE name = 'Test Representative'),
        (SELECT id FROM frescosG9.warehouse WHERE warehouse_code = 1001));


-- CABA - Fresco
INSERT INTO frescosG9.batch (batch_number, initial_quantity, actual_quantity, manufacturing_datetime, expire_date,
                             registration_temp, minimum_temp, product_id, sector_id, inbound_order_id)
VALUES (101, 50, 48, '2025-07-09 07:00:00', '2025-07-01', 5.0, 1.0,
        (SELECT id FROM frescosG9.product WHERE name = 'Test Product 1'),
        (SELECT id
         FROM frescosG9.sector
         WHERE sector_code = 101
           AND warehouse_id = (SELECT id FROM frescosG9.warehouse WHERE warehouse_code = 1001)),
        (SELECT id FROM frescosG9.inbound_order WHERE order_number = 1001));
