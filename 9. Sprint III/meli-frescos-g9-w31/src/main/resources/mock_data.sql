USE frescosG9;
-- Limpieza ordenada según dependencias (ajusta según tus FK si cambia tu modelo)
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


ALTER TABLE frescosG9.user_account ALTER COLUMN id RESTART WITH 1;
-- =========================
-- Carga User Accounts
-- =========================
INSERT INTO frescosG9.user_account (user_name, password) VALUES
  ('analopez', 'clave123'),
  ('jperez', 'clave123'),
  ('valesosa', 'clave123'),
  ('superlaesq', 'clave123'),
  ('distsur', 'clave123'),
  ('alimentoscampo', 'clave123'),
  ('cmendez.rep', 'clave123'),
  ('mvazquez.rep', 'clave123');

-- =========================
-- Product Types
-- =========================
INSERT INTO frescosG9.product_type (category, name, min_required_temp, max_required_temp) VALUES
  ('FS', 'Fresco', 1.0, 7.0);
INSERT INTO frescosG9.product_type (category, name, min_required_temp, max_required_temp) VALUES
  ('RF', 'Refrigerado', -2.0, 4.0);
INSERT INTO frescosG9.product_type (category, name, min_required_temp, max_required_temp) VALUES
  ('FF', 'Congelado', -25.0, -18.0);

-- =========================
-- Warehouses
-- =========================
    INSERT INTO frescosG9.warehouse (warehouse_code, name, location) VALUES
      (1, 'Depósito CABA', 'Av. Rivadavia 5000, CABA');
    INSERT INTO frescosG9.warehouse (warehouse_code, name, location) VALUES
      (2, 'Depósito GBA', 'Ruta 8 km 45, Pilar, BA');
    INSERT INTO frescosG9.warehouse (warehouse_code, name, location) VALUES
      (3, 'Depósito Córdoba', 'Av. Colón 2100, Córdoba Capital');

-- =========================
-- Warehouse Representatives (uno por uno)
-- =========================
INSERT INTO frescosG9.warehouse_rep (name, role, warehouse_id, user_id)
VALUES ('Ana López', 'Supervisor',
    (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1),
    (SELECT id FROM frescosG9.user_account WHERE user_name='analopez'));
INSERT INTO frescosG9.warehouse_rep (name, role, warehouse_id, user_id)
VALUES ('Carlos Méndez', 'Jefe de turno',
    (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=2),
    (SELECT id FROM frescosG9.user_account WHERE user_name='cmendez.rep'));
INSERT INTO frescosG9.warehouse_rep (name, role, warehouse_id, user_id)
VALUES ('Miguel Vázquez', 'Encargado',
    (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1),
    (SELECT id FROM frescosG9.user_account WHERE user_name='mvazquez.rep'));

-- =========================
-- Sellers (uno por uno)
-- =========================
INSERT INTO frescosG9.seller (name, user_id) VALUES
  ('Supermercado La Esquina', (SELECT id FROM frescosG9.user_account WHERE user_name='superlaesq'));
INSERT INTO frescosG9.seller (name, user_id) VALUES
  ('Distribuidora Sur', (SELECT id FROM frescosG9.user_account WHERE user_name='distsur'));
INSERT INTO frescosG9.seller (name, user_id) VALUES
  ('Alimentos del Campo', (SELECT id FROM frescosG9.user_account WHERE user_name='alimentoscampo'));

-- =========================
-- Buyers (uno por uno)
-- =========================
INSERT INTO frescosG9.buyer (name, user_id) VALUES
  ('Juan Perez', (SELECT id FROM frescosG9.user_account WHERE user_name='jperez'));
INSERT INTO frescosG9.buyer (name, user_id) VALUES
  ('Valeria Sosa', (SELECT id FROM frescosG9.user_account WHERE user_name='valesosa'));
INSERT INTO frescosG9.buyer (name, user_id) VALUES
  ('Martín Gómez', NULL);

-- =========================
-- Sectors (solo CABA de ejemplo, agrega más si necesitas)
-- =========================
INSERT INTO frescosG9.sector (product_type_id, sector_code, name, max_capacity, temp, warehouse_id) VALUES
  ((SELECT id FROM frescosG9.product_type WHERE category='FS'), 1, 'Frescos Norte CABA', 100, 4.0, (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1));
INSERT INTO frescosG9.sector (product_type_id, sector_code, name, max_capacity, temp, warehouse_id) VALUES
  ((SELECT id FROM frescosG9.product_type WHERE category='RF'), 2, 'Refrigerados Este CABA', 80, 2.0, (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1));
INSERT INTO frescosG9.sector (product_type_id, sector_code, name, max_capacity, temp, warehouse_id) VALUES
  ((SELECT id FROM frescosG9.product_type WHERE category='FF'), 3, 'Congelados Sur CABA', 70, -20.0, (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1));

-- =========================
-- Carriers
-- =========================
INSERT INTO frescosG9.carrier (name, contact) VALUES
  ('TransFresco SRL', 'trafresco@trafresco.com, 011-999-1122');
INSERT INTO frescosG9.carrier (name, contact) VALUES
  ('RefrigeradosExpress', 'contacto@revexp.com, 011-800-9988');
INSERT INTO frescosG9.carrier (name, contact) VALUES
  ('CBAFletes', 'cba@fletes.com, 0351-3229988');

-- =========================
-- Products (uno por uno)
-- =========================
INSERT INTO frescosG9.product (name, description, price, product_type_id, seller_id) VALUES
  ('Lechuga fresca', 'Lechuga recién cosechada', 150.00,
    (SELECT id FROM frescosG9.product_type WHERE category='FS'),
    (SELECT id FROM frescosG9.seller WHERE name='Alimentos del Campo'));
INSERT INTO frescosG9.product (name, description, price, product_type_id, seller_id) VALUES
  ('Yogur natural', 'Yogur descremado 1L', 220.00,
    (SELECT id FROM frescosG9.product_type WHERE category='RF'),
    (SELECT id FROM frescosG9.seller WHERE name='Supermercado La Esquina'));
INSERT INTO frescosG9.product (name, description, price, product_type_id, seller_id) VALUES
  ('Filet de merluza congelado', 'Envase 1kg', 600.00,
    (SELECT id FROM frescosG9.product_type WHERE category='FF'),
    (SELECT id FROM frescosG9.seller WHERE name='Distribuidora Sur'));

-- =========================
-- Inbound Orders (uno por uno)
-- =========================
INSERT INTO frescosG9.inbound_order (order_number, order_date, rep_id, warehouse_id) VALUES
  (1001, '2024-05-10',
    (SELECT id FROM frescosG9.warehouse_rep WHERE name='Ana López'),
    (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1));
INSERT INTO frescosG9.inbound_order (order_number, order_date, rep_id, warehouse_id) VALUES
  (1002, '2024-05-12',
    (SELECT id FROM frescosG9.warehouse_rep WHERE name='Carlos Méndez'),
    (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=2));
INSERT INTO frescosG9.inbound_order (order_number, order_date, rep_id, warehouse_id) VALUES
  (1003, '2024-05-14',
    (SELECT id FROM frescosG9.warehouse_rep WHERE name='Miguel Vázquez'),
    (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1));

-- =========================
-- Batch
-- =========================
INSERT INTO frescosG9.batch (batch_number, initial_quantity, actual_quantity, manufacturing_datetime, expire_date, registration_temp, minimum_temp, product_id, sector_id, inbound_order_id)
VALUES (
   101, 50, 48, TIMESTAMP '2024-05-09 07:00:00', '2026-07-01',  5.0,  1.0,
   (SELECT id FROM frescosG9.product WHERE name='Lechuga fresca'),
   (SELECT id FROM frescosG9.sector WHERE sector_code=1 AND warehouse_id=(SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1)),
   (SELECT id FROM frescosG9.inbound_order WHERE order_number=1001)
);
INSERT INTO frescosG9.batch (batch_number, initial_quantity, actual_quantity, manufacturing_datetime, expire_date, registration_temp, minimum_temp, product_id, sector_id, inbound_order_id)
VALUES (
   102, 80, 75, TIMESTAMP '2024-05-11 08:00:00', '2026-06-23',  2.0,  -2.0,
   (SELECT id FROM frescosG9.product WHERE name='Yogur natural'),
   (SELECT id FROM frescosG9.sector WHERE sector_code=2 AND warehouse_id=(SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1)),
   (SELECT id FROM frescosG9.inbound_order WHERE order_number=1002)
);
INSERT INTO frescosG9.batch (batch_number, initial_quantity, actual_quantity, manufacturing_datetime, expire_date, registration_temp, minimum_temp, product_id, sector_id, inbound_order_id)
VALUES (
   103, 60, 60, TIMESTAMP '2024-05-13 06:30:00', '2026-12-01', -20.0, -25.0,
   (SELECT id FROM frescosG9.product WHERE name='Filet de merluza congelado'),
   (SELECT id FROM frescosG9.sector WHERE sector_code=3 AND warehouse_id=(SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1)),
   (SELECT id FROM frescosG9.inbound_order WHERE order_number=1003)
);

-- =========================
-- Purchase Orders (uno por uno)
-- =========================
INSERT INTO frescosG9.purchase_order (creation_date, state, total_price, buyer_id, warehouse_id) VALUES
    ('2024-06-01', 'CARRITO', NULL,
     (SELECT id FROM frescosG9.buyer WHERE name='Juan Perez'),
     (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=1));
INSERT INTO frescosG9.purchase_order (creation_date, state, total_price, buyer_id, warehouse_id) VALUES
    ('2024-06-02', 'CONFIRMADA', 660.00,
     (SELECT id FROM frescosG9.buyer WHERE name='Valeria Sosa'),
     (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=2));
INSERT INTO frescosG9.purchase_order (creation_date, state, total_price, buyer_id, warehouse_id) VALUES
    ('2024-06-03', 'PAGADA', 600.00,
     (SELECT id FROM frescosG9.buyer WHERE name='Martín Gómez'),
     (SELECT id FROM frescosG9.warehouse WHERE warehouse_code=3));

-- =========================
-- purchase_order_item (uno por uno)
-- =========================
INSERT INTO frescosG9.purchase_order_item (amount, unit_price_at_sale, purchase_order_id, product_id, batch_id) VALUES
  (2, 150.00,
     (SELECT id FROM frescosG9.purchase_order WHERE state='CARRITO'),
     (SELECT id FROM frescosG9.product WHERE name='Lechuga fresca'),
     (SELECT id FROM frescosG9.batch WHERE batch_number=101)
  );
INSERT INTO frescosG9.purchase_order_item (amount, unit_price_at_sale, purchase_order_id, product_id, batch_id) VALUES
  (3, 220.00,
     (SELECT id FROM frescosG9.purchase_order WHERE state='CONFIRMADA'),
     (SELECT id FROM frescosG9.product WHERE name='Yogur natural'),
     (SELECT id FROM frescosG9.batch WHERE batch_number=102)
  );
INSERT INTO frescosG9.purchase_order_item (amount, unit_price_at_sale, purchase_order_id, product_id, batch_id) VALUES
  (1, 600.00,
     (SELECT id FROM frescosG9.purchase_order WHERE state='PAGADA'),
     (SELECT id FROM frescosG9.product WHERE name='Filet de merluza congelado'),
     (SELECT id FROM frescosG9.batch WHERE batch_number=103)
  );

-- =========================
-- Shipments (usa subselect para carrier_id)
-- =========================
INSERT INTO frescosG9.shipment (dispatch_date, shipment_state, details, purchase_order_id, carrier_id) VALUES
  (TIMESTAMP '2024-05-22 10:00:00', 'EN_PREPARACION', 'Caja térmica N.121',
     (SELECT id FROM frescosG9.purchase_order WHERE state='CONFIRMADA'),
     (SELECT id FROM frescosG9.carrier WHERE name='RefrigeradosExpress'));
INSERT INTO frescosG9.shipment (dispatch_date, shipment_state, details, purchase_order_id, carrier_id) VALUES
  (TIMESTAMP '2024-05-24 12:30:00', 'EN_RUTA', 'Bolsa refrigerada x2',
     (SELECT id FROM frescosG9.purchase_order WHERE state='PAGADA'),
     (SELECT id FROM frescosG9.carrier WHERE name='TransFresco SRL'));

-- FIN DEL SCRIPT