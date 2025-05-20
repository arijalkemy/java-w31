INSERT INTO clothing_item (name, type, brand, color, size, quantity, sale_price)
VALUES('Basic T-shirt', 'shirt', 'H&M', 'white', 'M', 50, 15.99),
('Slim Fit Jeans', 'pants', 'Levis', 'blue', 'L', 30, 49.99),
('Sport Jacket', 'jacket', 'Nike', 'black', 'XL', 20, 89.99),
('Casual Shirt', 'shirt', 'Zara', 'red', 'M', 25, 29.99),
('Summer Dress', 'dress', 'Forever 21', 'yellow', 'S', 40, 39.99),
('Hoodie', 'sweater', 'Adidas', 'gray', 'L', 35, 59.99),
('Denim Shorts', 'shorts', 'GAP', 'blue', 'M', 15, 24.99),
('Formal Pants', 'pants', 'Calvin Klein', 'black', 'M', 10, 69.99),
('Graphic Tee', 'shirt', 'Uniqlo', 'white', 'S', 60, 19.99),
('Windbreaker', 'jacket', 'Puma', 'green', 'L', 18, 74.99);


-- Ventas (sale)
INSERT INTO sale (date, total, payment_method) VALUES ('2024-05-10', 120.00, 'CASH');
INSERT INTO sale (date, total, payment_method) VALUES ('2024-05-11', 180.50, 'CREDIT_CARD');
INSERT INTO sale (date, total, payment_method) VALUES ( '2024-05-12', 99.99, 'DEBIT_CARD');
INSERT INTO sale (date, total, payment_method) VALUES ('2024-05-13', 75.25, 'CASH');
INSERT INTO sale (date, total, payment_method) VALUES ('2024-05-14', 210.75, 'CREDIT_CARD');

-- Relación entre ventas y prendas (sale_clothing_items)
-- Venta 1 incluye las prendas 1 y 2
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (1, 1);
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (1, 2);

-- Venta 2 incluye las prendas 3, 4 y 5
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (2, 3);
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (2, 4);
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (2, 5);

-- Venta 3 incluye la prenda 6
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (3, 6);

-- Venta 4 incluye las prendas 7 y 8
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (4, 7);
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (4, 8);

-- Venta 5 incluye las prendas 9 y 10
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (5, 9);
INSERT INTO sale_clothing_items (sale_number, clothing_item_id) VALUES (5, 10);
