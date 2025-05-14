-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema biblioteca_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca_db
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `biblioteca_db`;
CREATE DATABASE `biblioteca_db`;
CREATE SCHEMA IF NOT EXISTS `biblioteca_db` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
USE `biblioteca_db` ;

-- -----------------------------------------------------
-- Table `libro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `libro`;
CREATE TABLE IF NOT EXISTS `libro` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NOT NULL,
  `editorial` VARCHAR(255) NOT NULL,
  `area` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

SELECT * FROM libro;
-- -----------------------------------------------------
-- Table `autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `autor`;
CREATE TABLE IF NOT EXISTS `autor` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `nacionalidad` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

SELECT * FROM autor;
-- -----------------------------------------------------
-- Table `libro_autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `libro_autor`;
CREATE TABLE IF NOT EXISTS `libro_autor` (
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`id_autor` INT UNSIGNED NOT NULL,
  `id_libro` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_autor_idx` (`id_autor` ASC) VISIBLE,
  INDEX `id_libro_idx` (`id_libro` ASC) VISIBLE,
  CONSTRAINT `id_autor`
    FOREIGN KEY (`id_autor`)
    REFERENCES `autor` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `id_libro`
    FOREIGN KEY (`id_libro`)
    REFERENCES `libro` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudiante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE IF NOT EXISTS `estudiante` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  `carrera` VARCHAR(255) NOT NULL,
  `edad` INT(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

SELECT * FROM estudiante;
-- -----------------------------------------------------
-- Table `prestamo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE IF NOT EXISTS `prestamo` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_estudiante` INT UNSIGNED NOT NULL,
  `id_libro_prestado` INT UNSIGNED NOT NULL,
  `fecha_prestamo` DATETIME NOT NULL,
  `fecha_devolucion` DATETIME,
  `devuelto` BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `id_estudiante_idx` (`id_estudiante` ASC) VISIBLE,
  INDEX `id_libro_prestado_idx` (`id_libro_prestado` ASC) VISIBLE,
  CONSTRAINT `id_estudiante`
    FOREIGN KEY (`id_estudiante`)
    REFERENCES `estudiante` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `id_libro_prestado`
    FOREIGN KEY (`id_libro_prestado`)
    REFERENCES `libro` (`id`))
ENGINE = InnoDB;

SELECT * FROM prestamo;

-- Insertar datos en autor
INSERT INTO autor (nombre, nacionalidad) VALUES 
('Gabriel García Márquez', 'Colombiana'),
('J.K. Rowling', 'Británica'),
('Isabel Allende', 'Chilena'),
('George Orwell', 'Británica'),
('Julio Verne', 'Francesa');

INSERT INTO autor (nombre, nacionalidad) VALUES 
('Oliver Berry', 'Inglés');

-- Insertar datos en libro
INSERT INTO libro (titulo, editorial, area) VALUES 
('Cien años de soledad', 'Sudamericana', 'Literatura'),
('Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
('La casa de los espíritus', 'Debolsillo', 'Novela'),
('1984', 'Secker & Warburg', 'Ciencia Ficción'),
('Viaje al centro de la Tierra', 'Hetzel', 'Aventura');

INSERT INTO libro (titulo, editorial, area) VALUES 
('El universo: Guía de viaje', 'GeoPlaneta', 'Guía');

-- Insertar datos en libroautor
INSERT INTO libro_autor (id_libro, id_autor) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
INSERT INTO libro_autor (id_libro, id_autor) VALUES 
(6, 6);

-- Insertar datos en estudiante
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES 
('Laura', 'Martínez', 'Calle 123 #45-67', 'Ingeniería de Sistemas', 22),
('Juan', 'Pérez', 'Carrera 10 #12-34', 'Medicina', 24),
('María', 'Gómez', 'Avenida 5 #67-89', 'Derecho', 21),
('Carlos', 'López', 'Transversal 8 #32-10', 'Psicología', 23),
('Ana', 'Torres', 'Diagonal 4 #11-22', 'Arquitectura', 25);

INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES ('Carla', 'Pérez', 'Carrera 9 #3-10', 'Informática', 21);
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES ('Filippo', 'Galli', 'Calle 10 #3-10', 'Medicina', 22);

-- Insertar datos en prestamo
INSERT INTO prestamo (id_estudiante, id_libro_prestado, fecha_prestamo, fecha_devolucion, devuelto) VALUES 
(1, 1, '2025-05-01', '2025-05-10', TRUE),
(2, 2, '2025-05-05', NULL, FALSE),
(3, 3, '2025-05-03', '2025-05-12', TRUE),
(4, 4, '2025-05-07', NULL, FALSE),
(5, 5, '2025-05-08', NULL, FALSE);

INSERT INTO prestamo (id_estudiante, id_libro_prestado, fecha_prestamo, fecha_devolucion, devuelto) VALUES 
(7, 3, '2025-05-01', '2025-05-10', TRUE);

-- Consultas
--
-- Listar los datos de los autores.
SELECT * FROM autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM estudiante
WHERE carrera = 'informatica';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM autor
WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';

-- ¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE area NOT LIKE 'internet';

-- Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
INNER JOIN libro_autor la ON a.id = la.id_autor
INNER JOIN libro l ON l.id = la.id_libro
WHERE l.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo, l.area
FROM estudiante e
INNER JOIN prestamo p ON e.id = p.id_estudiante
INNER JOIN libro l ON l.id = p.id_libro_prestado
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT nombre, edad
FROM estudiante
WHERE edad = (SELECT MIN(edad) FROM estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, l.titulo, l.area
FROM estudiante e
INNER JOIN prestamo p ON p.id_estudiante = e.id
INNER JOIN libro l ON l.id = p.id_libro_prestado
WHERE l.area = 'base de datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo, l.editorial, l.area, a.nombre
FROM libro l
INNER JOIN libro_autor la ON la.id_libro = l.id
INNER JOIN autor a ON la.id_autor = a.id
WHERE a.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 13/05/2025.
SELECT l.titulo, p.fecha_prestamo, p.fecha_devolucion
FROM libro l
INNER JOIN prestamo p ON p.id_libro_prestado = l.id
WHERE p.devuelto IS FALSE AND fecha_prestamo BETWEEN '2025-05-08' AND '2025-05-12';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
