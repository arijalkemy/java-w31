-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema internet_provider_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `internet_provider_db` ;

-- -----------------------------------------------------
-- Schema internet_provider_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `internet_provider_db` DEFAULT CHARACTER SET utf8 ;
USE `internet_provider_db` ;

-- -----------------------------------------------------
-- Table `internet_provider_db`.`plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `internet_provider_db`.`plan` ;

CREATE TABLE IF NOT EXISTS `internet_provider_db`.`plan` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `velocidad` DECIMAL(6) UNSIGNED NOT NULL,
  `precio` DECIMAL(13,2) UNSIGNED NOT NULL,
  `descuento` DECIMAL(3,2) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `internet_provider_db`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `internet_provider_db`.`cliente` ;

CREATE TABLE IF NOT EXISTS `internet_provider_db`.`cliente` (
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`dni` DOUBLE NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  `fecha_nacimiento` DATETIME NOT NULL,
  `provincia` VARCHAR(255) NOT NULL,
  `ciudad` VARCHAR(255) NOT NULL,
  `id_plan` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `id_plan_idx` (`id_plan` ASC) VISIBLE,
  CONSTRAINT `id_plan`
    FOREIGN KEY (`id_plan`)
    REFERENCES `internet_provider_db`.`plan` (`id`))
ENGINE = InnoDB;


INSERT INTO internet_provider_db.plan (velocidad, precio, descuento) VALUES
(50, 10000.00, 0.05),
(100, 15000.00, 0.10),
(300, 25000.00, 0.15),
(500, 35000.00, 0.20),
(1000, 50000.00, 0.25);

INSERT INTO internet_provider_db.cliente (nombre, apellido, dni, fecha_nacimiento, provincia, ciudad, id_plan) VALUES
('Laura', 'Martínez', 1023456789, '1999-05-10 00:00:00', 'Antioquia', 'Medellín', 1),
('Carlos', 'Gómez', 2034567890, '1990-08-22 00:00:00', 'Cundinamarca', 'Bogotá', 2),
('Ana', 'Torres', 3045678901, '1985-03-15 00:00:00', 'Valle del Cauca', 'Cali', 3),
('Juan', 'Pérez', 4056789012, '1992-11-03 00:00:00', 'Santander', 'Bucaramanga', 4),
('María', 'López', 5067890123, '2000-01-28 00:00:00', 'Atlántico', 'Barranquilla', 5),
('Sebastián', 'Ramírez', 6078901234, '1995-07-14 00:00:00', 'Tolima', 'Ibagué', 2),
('Valentina', 'Castaño', 7089012345, '1997-09-09 00:00:00', 'Risaralda', 'Pereira', 3),
('Andrés', 'Mejía', 8090123456, '1988-12-01 00:00:00', 'Boyacá', 'Tunja', 1),
('Camila', 'Ortega', 9012345678, '1993-04-25 00:00:00', 'Magdalena', 'Santa Marta', 4),
('Mateo', 'Zapata', 1123456789, '2001-06-30 00:00:00', 'Huila', 'Neiva', 5);

-- Muestra todos los clientes que viven en la ciudad de Medellín.
SELECT *
FROM cliente
WHERE ciudad = 'Medellín';

-- Lista los planes cuya velocidad sea mayor a 100 Mbps.
SELECT *
FROM plan
WHERE velocidad > 100;

-- Obtén el nombre, apellido y precio del plan de cada cliente.
SELECT c.nombre, c.apellido, p.precio
FROM cliente c
INNER JOIN plan p ON p.id = c.id_plan;

-- Cuenta cuántos clientes están suscritos a cada plan.
SELECT p.id plan, COUNT(*) cant_clientes
FROM cliente c
INNER JOIN plan p ON p.id = c.id_plan
GROUP BY p.id;

-- Muestra los clientes que nacieron antes del año 1990.
SELECT *
FROM cliente
WHERE fecha_nacimiento < '1990-01-01';

-- Lista todos los planes que tienen un descuento mayor o igual al 15%.
SELECT *
FROM plan
WHERE descuento >= 0.15;


-- Muestra los clientes agrupados por provincia y cuenta cuántos hay en cada una.
SELECT provincia, COUNT(*)
FROM cliente
GROUP BY provincia;

-- Encuentra los clientes que no tienen asignado ningún plan (id_plan es NULL).
SELECT *
FROM cliente
WHERE id_plan IS NULL;

-- Ordena a los clientes por fecha de nacimiento, del más joven al más viejo.
SELECT *
FROM cliente
ORDER BY fecha_nacimiento DESC;

-- Calcula el total de ingresos teóricos (sin aplicar descuento) agrupado por cada plan.
SELECT p.id plan, p.precio * COUNT(*) ingresos_totales
FROM cliente c
INNER JOIN plan p ON p.id = c.id_plan
GROUP BY p.id;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
