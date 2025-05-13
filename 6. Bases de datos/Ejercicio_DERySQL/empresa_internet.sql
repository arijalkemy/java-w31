-- Base de Datos empresa_internet

-- Ejercicio 3

DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

DROP TABLE IF EXISTS `packs`;
DROP TABLE IF EXISTS `customers`;

CREATE TABLE `packs` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `speed` float,
  `price` decimal,
  `discount` decimal,
  PRIMARY KEY(`id`)
);

CREATE TABLE `customers` (
  `id` integer NOT NULL AUTO_INCREMENT,
  `dni` varchar(255),
  `first_name` varchar(255),
  `last_name` varchar(255),
  `birthdate` timestamp,
  `province` varchar(255),
  `city` varchar(255),
  `pack_id` integer NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customers_pack_id_foreign` (`pack_id`),
  CONSTRAINT `customers_pack_id_foreign` FOREIGN KEY (`pack_id`) REFERENCES `packs` (`id`)
  
);

INSERT INTO packs (speed, price, discount) VALUES 
(50.0, 25.99, 0.00),
(100.0, 35.99, 5.00),
(300.0, 49.99, 10.00),
(500.0, 65.99, 15.00),
(1000.0, 89.99, 20.00);

INSERT INTO customers (dni, first_name, last_name, birthdate, province, city, pack_id) VALUES
('10000001', 'Ana', 'Gómez', '1990-05-10 00:00:00', 'Buenos Aires', 'La Plata', 1),
('10000002', 'Luis', 'Martínez', '1985-08-22 00:00:00', 'Córdoba', 'Villa Carlos Paz', 2),
('10000003', 'María', 'Pérez', '1993-12-01 00:00:00', 'Santa Fe', 'Rosario', 3),
('10000004', 'Juan', 'Rodríguez', '1978-03-15 00:00:00', 'Mendoza', 'Godoy Cruz', 1),
('10000005', 'Lucía', 'Fernández', '2000-07-07 00:00:00', 'Tucumán', 'San Miguel', 4),
('10000006', 'Pedro', 'López', '1995-11-30 00:00:00', 'Buenos Aires', 'Quilmes', 2),
('10000007', 'Sofía', 'Díaz', '1989-06-20 00:00:00', 'Salta', 'Salta Capital', 3),
('10000008', 'Carlos', 'Sánchez', '1982-09-18 00:00:00', 'Entre Ríos', 'Paraná', 5),
('10000009', 'Camila', 'Ruiz', '1999-02-25 00:00:00', 'Neuquén', 'Cutral Có', 2),
('10000010', 'Diego', 'Molina', '1991-01-10 00:00:00', 'Chaco', 'Resistencia', 4);

-- Ejercicio 4
-- 1. Consultar todos los clientes
SELECT * from customers;
-- 2. Consultar clientes que viven en una ciudad especifica
SELECT * FROM customers WHERE city = 'Rosario';
-- 3. Clientes que nacieron después del año 1990
SELECT * FROM customers
WHERE birthdate > '1990-01-01';
-- 4. Consultar cuantos clientes tiene cada plan
SELECT p.id, p.speed, COUNT(c.id) AS total_clients
FROM packs p
LEFT JOIN customers c ON p.id = c.pack_id
GROUP BY p.id, p.speed;
-- 5. Edad promedio
SELECT 
  AVG(YEAR(CURDATE()) - YEAR(birthdate)) AS avg_age
FROM customers;
-- 6. Clientes por provincia
SELECT province, COUNT(*) AS Total
FROM customers
GROUP BY province;
-- 7. Consultar todos los planes
SELECT * FROM packs;
-- 8. Consultar los planes con velocidad mayor a 250 Mbps
SELECT * FROM packs WHERE speed > 250;
-- 9. Obtener todos los clientes cuto nombre inicie con C
SELECT * FROM customers WHERE first_name LIKE "C%";
-- 10. Obtener los clientes con su plan
SELECT 
  c.first_name,
  c.last_name,
  p.speed,
  p.price
FROM customers c
LEFT JOIN packs p ON c.pack_id = p.id; 

