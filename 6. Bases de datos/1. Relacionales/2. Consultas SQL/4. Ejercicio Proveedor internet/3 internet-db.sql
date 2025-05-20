--
-- Drops
--
DROP TABLE IF EXISTS `plan_internet`;
DROP TABLE IF EXISTS `cliente`;
DROP DATABASE IF EXISTS `empresa_internet`;

--
-- Estructura del esquema
--
CREATE DATABASE `empresa_internet`;
USE `empresa_internet`;

--
-- Estructura de la tabla Cliente
--
CREATE TABLE `cliente` (
  `dni` integer PRIMARY KEY,
  `nombre` varchar(255),
  `apellido` varchar(255),
  `fecha_nacimiento` date,
  `provincia` varchar(255),
  `ciudad` varchar(255),
  `created_at` timestamp
);

--
-- Estructura de la tabla Plan Internet
--
CREATE TABLE `plan_internet` (
  `id` integer PRIMARY KEY,
  `velocidad` integer,
  `precio` integer,
  `descuento` float,
  `dni_cliente` integer
);
ALTER TABLE `plan_internet` ADD FOREIGN KEY (`dni_cliente`) REFERENCES `cliente` (`dni`);

--
-- Ingreso de 10 registros en la tabla Cliente
--
INSERT INTO `cliente` VALUES
(12345678, 'Juan', 'Pérez', '1985-05-15', 'Buenos Aires', 'Buenos Aires', '2023-10-01 10:15:00'),
(23456789, 'María', 'González', '1990-07-22', 'Córdoba', 'Córdoba', '2023-10-01 11:00:00'),
(34567890, 'Carlos', 'Ramírez', '1978-03-30', 'Santa Fe', 'Rosario', '2023-10-01 09:45:00'),
(45678901, 'Ana', 'López', '1982-11-12', 'Mendoza', 'Mendoza', '2023-10-01 08:20:00'),
(56789012, 'Luis', 'Martínez', '1995-02-14', 'Tucumán', 'San Miguel de Tucumán', '2023-10-01 07:30:00'),
(67890123, 'Patricia', 'Fernández', '1988-08-19', 'Salta', 'Salta', '2023-10-01 14:05:00'),
(78901234, 'Jorge', 'Sánchez', '1975-01-05', 'Jujuy', 'San Salvador de Jujuy', '2023-10-01 15:20:00'),
(89012345, 'Laura', 'Castro', '1993-06-07', 'Entre Ríos', 'Paraná', '2023-10-01 16:10:00'),
(90123456, 'Diego', 'Herrera', '1980-09-23', 'Neuquén', 'Neuquén', '2023-10-01 12:45:00'),
(12340987, 'Marta', 'Ríos', '1969-12-11', 'Chubut', 'Comodoro Rivadavia', '2023-10-01 13:00:00');

--
-- Ingreso de 5 registros en la tabla Plan Internet
--
INSERT INTO `plan_internet` VALUES
(1, 100, 3000, 0.10, 12345678),
(2, 200, 5000, 0.15, 23456789),
(3, 150, 4500, 0.05, 34567890),
(4, 50, 2000, 0.20, 45678901),
(5, 300, 7500, 0.10, 56789012);