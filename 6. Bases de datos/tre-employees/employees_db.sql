-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema employees_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `employees_db` ;

-- -----------------------------------------------------
-- Schema employees_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `employees_db` DEFAULT CHARACTER SET utf8 ;
USE `employees_db` ;

-- -----------------------------------------------------
-- Table `employees_db`.`departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employees_db`.`departamento` ;

CREATE TABLE IF NOT EXISTS `employees_db`.`departamento` (
  `nro_depto` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `localidad` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nro_depto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employees_db`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employees_db`.`empleado` ;

CREATE TABLE IF NOT EXISTS `employees_db`.`empleado` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  `puesto` VARCHAR(255) NOT NULL,
  `fecha_alta` DATETIME NOT NULL,
  `salario` DECIMAL(13,2) NOT NULL,
  `comision` DECIMAL(13,2) NOT NULL,
  `nro_depto` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `nro_depto_idx` (`nro_depto` ASC) VISIBLE,
  CONSTRAINT `nro_depto`
    FOREIGN KEY (`nro_depto`)
    REFERENCES `employees_db`.`departamento` (`nro_depto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `departamento` (nombre, localidad) VALUES 
('Software','Los Tigres'),
('Sistemas','Guadalupe'),
('Contabilidad','La Roca'),
('Ventas','Plata');

INSERT INTO `empleado` (nombre, apellido, puesto, fecha_alta, salario, comision, nro_depto) VALUES 
('César','Piñero','Vendedor','2018-05-12',80000,15000,4),
('Yosep','Kowaleski','Analista','2015-07-14',140000,0,2),
('Mariela','Barrios','Director','2014-06-05',185000,0,3),
('Jonathan','Aguilera','Vendedor','2015-06-03',85000,10000,4),
('Daniel','Brezezicki','Vendedor','2018-03-03',83000,10000,4),
('Mito','Barchuk','Presidente','2014-06-05',190000,0,3),
('Emilio','Galarza','Desarrollador','2014-08-02',60000,0,1);

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT d.nombre, e.puesto, d.localidad
FROM empleado e
INNER JOIN departamento d ON d.nro_depto = e.nro_depto
WHERE e.puesto = 'Vendedor'
GROUP BY d.nro_depto;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nro_depto, d.nombre, COUNT(*) tot_emp
FROM departamento d
INNER JOIN empleado e ON e.nro_depto = d.nro_depto
GROUP BY d.nro_depto
HAVING tot_emp > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre depto
FROM empleado e
INNER JOIN departamento d ON d.nro_depto = e.nro_depto
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*, d.nombre
FROM empleado e
INNER JOIN departamento d ON d.nro_depto = e.nro_depto
WHERE d.nombre = 'contabilidad'
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM empleado e
INNER JOIN departamento d ON d.nro_depto = e.nro_depto
WHERE d.nombre = 'ventas'
ORDER BY e.salario DESC
LIMIT 1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
