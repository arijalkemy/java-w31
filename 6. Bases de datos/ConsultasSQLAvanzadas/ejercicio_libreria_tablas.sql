DROP DATABASE IF EXISTS libreria;
CREATE DATABASE libreria;
USE libreria;

CREATE TABLE `libro`(
	`id_libro` int NOT NULL,
    `titulo` varchar(255),
    `editorial` varchar(255),
	`area`varchar(255),
    PRIMARY KEY (`id_libro`)
);

CREATE TABLE `autor` (
	`id_autor` int NOT NULL,
	`nombre` varchar(255),
    `nacionalidad` varchar(255),
	PRIMARY KEY (`id_autor`)
);

CREATE TABLE `estudiante` (
	`id_lector` int NOT NULL,
	`nombre` varchar(255),
    `apellido` varchar(255),
    `direccion` varchar(255),
    `carrera` varchar(255),
    `edad` int,
	PRIMARY KEY (`id_lector`)
);

CREATE TABLE `libro_autor` (
	`id_autor` int NOT NULL,
    `id_libro` int NOT NULL,
	FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`),
    FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`)
);

CREATE TABLE `prestamo` (
	`id_lector` int NOT NULL,
    `id_libro` int NOT NULL,
    `fecha_prestamo` date,
    `fecha_devolucion` date,
    `devuelto` bool,
	FOREIGN KEY (`id_lector`) REFERENCES `estudiante` (`id_lector`),
    FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`)
);

-- 5 registros para la tabla `libro`
INSERT INTO `libro` (`id_libro`, `titulo`, `editorial`, `area`) VALUES
(101, 'El Gran Gatsby', 'Penguin Random House', 'Ficción'),
(102, 'Sapiens: De animales a dioses', 'Debate', 'Historia'),
(103, 'Cien Años de Soledad', 'Editorial Sudamericana', 'Ficción'),
(104, 'Fundamentos de Programación', 'McGraw-Hill', 'Informática'),
(105, 'Introducción a la Economía', 'Pearson', 'Economía');

-- 5 registros para la tabla `autor`
INSERT INTO `autor` (`id_autor`, `nombre`, `nacionalidad`) VALUES
(1, 'F. Scott Fitzgerald', 'Italia'),
(2, 'Yuval Noah Harari', 'Israel'),
(3, 'Gabriel García Márquez', 'Colombia'),
(4, 'Joyanes Aguilar', 'Español'),
(5, 'Paul Krugman', 'Estados Unidos');

-- 5 registros para la tabla `estudiante`
INSERT INTO `estudiante` (`id_lector`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`) VALUES
(201, 'Juan', 'Perez', 'Calle Falsa 123', 'Ingeniería de Sistemas', 20),
(202, 'Maria', 'Lopez', 'Avenida Siempreviva 742', 'Derecho', 22),
(203, 'Carlos', 'Garcia', 'Boulevard de los Sueños Rotos 5', 'Administración', 19),
(204, 'Ana', 'Martinez', 'Paseo del Prado s/n', 'Arquitectura', 21),
(205, 'Luis', 'Fernandez', 'Plaza Mayor 1', 'Economía', 20);

-- 5 registros para la tabla `libro_autor`
INSERT INTO `libro_autor` (`id_autor`, `id_libro`) VALUES
(1, 101), 
(2, 102),
(3, 103), 
(4, 104),
(5, 105);

-- 5 registros para la tabla `prestamo`
INSERT INTO `prestamo` (`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`) VALUES
(201, 104, '2023-10-26', '2023-11-10', TRUE),
(202, 102, '2023-10-27', NULL, FALSE), 
(203, 105, '2023-10-28', '2023-11-15', TRUE),
(204, 101, '2023-10-29', NULL, FALSE), 
(201, 103, '2023-10-30', NULL, FALSE);

-- 1. Listar los datos de los autores.
SELECT *
FROM autor;

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM estudiante;

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad
FROM autor
WHERE nacionalidad LIKE 'Francia' OR nacionalidad LIKE 'Italia';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE 'G%';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM estudiante
ORDER BY edad
LIMIT 1;
