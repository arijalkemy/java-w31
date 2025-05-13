DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;
CREATE TABLE `client` (
  `id` integer UNIQUE PRIMARY KEY NOT NULL,
  `dni` varchar(255),
  `nombre` varchar(255),
  `apellido` varchar(255),
  `fecha_de_nacimiento` varchar(255),
  `provincia` varchar(255),
  `ciudad` varchar(255),
  `plan_id` integer,
  `created_at` timestamp
);
CREATE TABLE `plan` (
  `id` integer UNIQUE PRIMARY KEY NOT NULL,
  `idx_plan` varchar(255),
  `megas` integer,
  `precio` decimal,
  `descuento` decimal,
  `created_at` timestamp
);
ALTER TABLE `client` ADD FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`);
INSERT INTO `plan` (id, idx_plan, megas, precio, descuento, created_at) VALUES
(1, 'Plan A', 500, 29.99, 0, NOW()),
(2, 'Plan B', 1000, 49.99, 10, NOW()),
(3, 'Plan C', 2000, 69.99, 5, NOW()),
(4, 'Plan D', 3000, 89.99, 15, NOW()),
(5, 'Plan E', 5000, 109.99, 20, NOW());
INSERT INTO `client` (id, dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad, plan_id, created_at) VALUES
(1, '12345678', 'Juan', 'Pérez', '1985-01-10', 'Buenos Aires', 'CABA', 1, NOW()),
(2, '87654321', 'Maria', 'López', '1990-05-15', 'Córdoba', 'Córdoba', 2, NOW()),
(3, '11223344', 'Carlos', 'Gómez', '1975-12-30', 'Buenos Aires', 'La Plata', 1, NOW()),
(4, '44332211', 'Laura', 'Martínez', '1988-08-20', 'Santa Fe', 'Santa Fe', 3, NOW()),
(5, '99887766', 'Pedro', 'Fernández', '1995-02-25', 'Mendoza', 'Mendoza', 2, NOW()),
(6, '55556666', 'Ana', 'Hernández', '2000-04-05', 'Tucumán', 'San Miguel de Tucumán', 4, NOW()),
(7, '66665555', 'Jorge', 'Jiménez', '1982-09-14', 'Neuquén', 'Neuquén', 3, NOW()),
(8, '44443333', 'Cecilia', 'Ramírez', '1998-03-11', 'Chaco', 'Resistencia', 5, NOW()),
(9, '77778888', 'Roberto', 'Fernández', '1978-06-23', 'Salta', 'Salta', 4, NOW()),
(10, '22221111', 'Lucía', 'Torres', '1991-11-01', 'Río Negro', 'Viedma', 5, NOW());

-- Precio promedio
SELECT AVG(precio) AS precio_promedio
FROM plan;

-- Descuento mayor a 10 %
SELECT idx_plan As MayorA10
FROM plan
WHERE descuento > 10;

-- Plan mas caro
SELECT idx_plan, megas, precio
FROM plan
ORDER BY precio DESC
LIMIT 1;

-- Obtener el número total de planes disponibles
SELECT COUNT(*) AS total_planes
FROM plan;

-- Clientes y sus planes
SELECT c.id, c.nombre, c.apellido, p.idx_plan, p.megas, p.precio
FROM client c
JOIN plan p ON c.plan_id = p.id;

-- Clientes por cada plan
SELECT p.idx_plan, COUNT(c.id) AS total_clientes
FROM plan p
LEFT JOIN client c ON p.id = c.plan_id
GROUP BY p.idx_plan;