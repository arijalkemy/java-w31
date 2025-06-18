DROP DATABASE frescosG9;

CREATE DATABASE frescosG9;

USE frescosG9;

CREATE TABLE `product_type` (
                               `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Tipo Producto',
                               `category` varchar(2) UNIQUE NOT NULL,
                               `name` varchar(255) NOT NULL,
                               `min_required_temp` decimal(5,1) NOT NULL,
                               `max_required_temp` decimal(5,1) NOT NULL
);

CREATE TABLE `seller` (
                          `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Vendedor',
                          `name` varchar(255) NOT NULL,
                          `user_id` bigint
);

CREATE TABLE `product` (
                           `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Producto',
                           `name` varchar(255) NOT NULL,
                           `description` text,
                           `price` decimal(12,2) NOT NULL,
                           `product_type_id` bigint NOT NULL,
                           `seller_id` bigint NOT NULL
);

CREATE TABLE `warehouse` (
                             `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Almacén',
                             `warehouse_code` bigint UNIQUE NOT NULL,
                             `name` varchar(255) NOT NULL,
                             `location` text
);

CREATE TABLE `sector` (
                          `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Sector',
                          `product_type_id` bigint NOT NULL COMMENT 'Type of product this sector is designed for',
                          `sector_code` bigint NOT NULL COMMENT 'Should be unique within a warehouse',
                          `name` varchar(255),
                          `current_capacity` int DEFAULT 0,
                          `max_capacity` int NOT NULL,
                          `temp` decimal(5,1),
                          `warehouse_id` bigint NOT NULL
);

CREATE TABLE `warehouse_rep` (
                                `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Representante del Almacén',
                                `name` varchar(255) NOT NULL,
                                `role` varchar(100),
                                `warehouse_id` bigint NOT NULL,
                                `user_id` bigint NOT NULL
);

CREATE TABLE `inbound_order` (
                                `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Orden de Ingreso de Mercadería',
                                `order_number` bigint UNIQUE NOT NULL,
                                `order_date` date NOT NULL,
                                `seller_id` bigint NOT NULL,
                                `rep_id` bigint NOT NULL,
                                `warehouse_id` bigint NOT NULL
);

CREATE TABLE `batch` (
                         `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Lote de Stock',
                         `batch_number` bigint NOT NULL,
                         `initial_quantity` int NOT NULL,
                         `actual_quantity` int NOT NULL,
                         `manufacturing_datetime` timestamp COMMENT 'Corresponds to manufacturing_time in JSON',
                         `expire_date` date NOT NULL COMMENT 'Due date',
                         `registration_temp` decimal(5,1),
                         `minimum_temp` decimal(5,1),
                         `product_id` bigint NOT NULL,
                         `sector_id` bigint NOT NULL COMMENT 'Current sector where it is stored',
                         `inbound_order_id` bigint NOT NULL
);

CREATE TABLE `buyer` (
                         `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Comprador',
                         `name` varchar(255) NOT NULL,
                         `user_id` bigint
);

CREATE TABLE `purchase_order` (
                                 `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Orden de Compra (Cliente)',
                                 `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 `state` varchar(50) DEFAULT 'CARRITO' COMMENT 'e.g., CARRITO, CONFIRMADA, PAGADA',
                                 `total_price` decimal(12,2),
                                 `buyer_id` bigint NOT NULL,
                                 `warehouse_id` bigint NOT NULL COMMENT 'Warehouse fulfilling this order'
);

CREATE TABLE `purchase_order_item` (
                                     `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Item de la Orden de Compra',
                                     `amount` int NOT NULL,
                                     `unit_price_at_sale` decimal(12,2) NOT NULL,
                                     `purchase_order_id` bigint NOT NULL,
                                     `product_id` bigint NOT NULL,
                                     `batch_id` bigint COMMENT 'FK to Lote, Nullable, for picking process'
);

CREATE TABLE `carrier` (
                           `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Transportista',
                           `name` varchar(255) NOT NULL,
                           `contact` text
);

CREATE TABLE `shipment` (
                            `id` bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID Envío',
                            `dispatch_date` timestamp,
                            `shipment_state` varchar(50) COMMENT 'e.g., EN_PREPARACION, EN_RUTA, ENTREGADO',
                            `details` text,
                            `purchase_order_id` bigint UNIQUE NOT NULL COMMENT 'Assuming one shipment per order',
                            `carrier_id` bigint NOT NULL
);

CREATE TABLE `user_account` (
                               `id` bigint PRIMARY KEY AUTO_INCREMENT,
                               `user_name` varchar(50) NOT NULL,
                               `password` varchar(255) NOT NULL
);

CREATE INDEX product_index_0 ON product (product_type_id);
CREATE INDEX product_index_1 ON product (seller_id);

CREATE INDEX sector_index_2 ON sector (warehouse_id);
CREATE INDEX sector_index_3 ON sector (product_type_id);
CREATE UNIQUE INDEX sector_index_4 ON sector (sector_code, warehouse_id);

CREATE INDEX warehouse_rep_index_5 ON warehouse_rep (warehouse_id);

CREATE INDEX inbound_order_index_6 ON inbound_order (seller_id);
CREATE INDEX inbound_order_index_7 ON inbound_order (rep_id);
CREATE INDEX inbound_order_index_8 ON inbound_order (warehouse_id);

CREATE INDEX batch_index_9 ON batch (product_id);
CREATE INDEX batch_index_10 ON batch (sector_id);
CREATE INDEX batch_index_11 ON batch (inbound_order_id);
CREATE INDEX batch_index_12 ON batch (expire_date);

CREATE INDEX purchase_order_index_13 ON purchase_order (buyer_id);
CREATE INDEX purchase_order_index_14 ON purchase_order (warehouse_id);

CREATE INDEX purchase_order_item_index_15 ON purchase_order_item (purchase_order_id);
CREATE INDEX purchase_order_item_index_16 ON purchase_order_item (product_id);
CREATE INDEX purchase_order_item_index_17 ON purchase_order_item (batch_id);

CREATE INDEX shipment_index_18 ON shipment (purchase_order_id);
CREATE INDEX shipment_index_19 ON shipment (carrier_id);

ALTER TABLE product ADD FOREIGN KEY (product_type_id) REFERENCES product_type (id);
ALTER TABLE sector ADD FOREIGN KEY (product_type_id) REFERENCES product_type (id);
ALTER TABLE product ADD FOREIGN KEY (seller_id) REFERENCES seller (id);
ALTER TABLE inbound_order ADD FOREIGN KEY (seller_id) REFERENCES seller (id);
ALTER TABLE sector ADD FOREIGN KEY (warehouse_id) REFERENCES warehouse (id);
ALTER TABLE warehouse_rep ADD FOREIGN KEY (warehouse_id) REFERENCES warehouse (id);
ALTER TABLE inbound_order ADD FOREIGN KEY (warehouse_id) REFERENCES warehouse (id);
ALTER TABLE purchase_order ADD FOREIGN KEY (warehouse_id) REFERENCES warehouse (id);
ALTER TABLE batch ADD FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE purchase_order_item ADD FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE batch ADD FOREIGN KEY (sector_id) REFERENCES sector (id);
ALTER TABLE inbound_order ADD FOREIGN KEY (rep_id) REFERENCES warehouse_rep (id);
ALTER TABLE batch ADD FOREIGN KEY (inbound_order_id) REFERENCES inbound_order (id);
ALTER TABLE purchase_order ADD FOREIGN KEY (buyer_id) REFERENCES buyer (id);
ALTER TABLE purchase_order_item ADD FOREIGN KEY (purchase_order_id) REFERENCES purchase_order (id);
ALTER TABLE purchase_order_item ADD FOREIGN KEY (batch_id) REFERENCES batch (id);
ALTER TABLE shipment ADD FOREIGN KEY (purchase_order_id) REFERENCES purchase_order (id);
ALTER TABLE shipment ADD FOREIGN KEY (carrier_id) REFERENCES carrier (id);
ALTER TABLE buyer ADD FOREIGN KEY (user_id) REFERENCES user_account (id);
ALTER TABLE seller ADD FOREIGN KEY (user_id) REFERENCES user_account (id);