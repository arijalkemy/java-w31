-- Crear base de datos Ejercicio

DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

-- Tablas

DROP TABLE IF EXISTS `autor`;
DROP TABLE IF EXISTS `estudiante`;
DROP TABLE IF EXISTS `libro`;
DROP TABLE IF EXISTS `prestamo`;
DROP TABLE IF EXISTS `libro_autor`;

CREATE TABLE `autor`(
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255),
  `nacionalidad` VARCHAR(255),
  PRIMARY KEY (`id`)
);

CREATE TABLE `estudiante`(
	`id` integer NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(255),
    `apellido` VARCHAR(255),
    `direccion` VARCHAR(255),
    `carrera` VARCHAR(255),
    `edad` integer,
    PRIMARY KEY (`id`)
);

CREATE TABLE `libro`(
	`id` integer NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(255),
    `editorial` VARCHAR(255),
    `area` VARCHAR(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE `libro_autor`(
	`id_libro` integer NOT NULL,
	`id_autor` integer NOT NULL,
  PRIMARY KEY (`id_libro`, `id_autor`),
  FOREIGN KEY (`id_libro`) REFERENCES libro(`id`),
  FOREIGN KEY (`id_autor`) REFERENCES autor(`id`)
);

CREATE TABLE `prestamo`(
	`id_libro` integer NOT NULL,
	`id_estudiante` integer NOT NULL,
    `fecha_prestamo`timestamp,
    `fecha_devolucion` timestamp,
    `devuelto` boolean,
  PRIMARY KEY (`id_libro`, `id_estudiante`),
  FOREIGN KEY (`id_libro`) REFERENCES libro(`id`),
  FOREIGN KEY (`id_estudiante`) REFERENCES estudiante(`id`)
  
);

INSERT INTO autor (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('Isabel Allende', 'Chilena'),
('Jorge Luis Borges', 'Argentina'),
('Mario Vargas Llosa', 'Peruana'),
('Julio Cortázar', 'Argentina');

INSERT INTO autor (nombre, nacionalidad) VALUES ('J.K. Rowling','Británica'),('Isaac Asimov','Estadounidense'),('Albert Camus','Francesa'),('Umberto Eco','Italiana'),('Margaret Atwood','Canadiense');

INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Ana', 'Pérez', 'Calle 123', 'Ingeniería', 21),
('Luis', 'Gómez', 'Av. Libertador 456', 'Medicina', 23),
('María', 'López', 'Calle Falsa 742', 'Derecho', 22),
('Carlos', 'Martínez', 'Calle 10', 'Psicología', 24),
('Lucía', 'Ramírez', 'Av. Siempre Viva 101', 'Arquitectura', 20);

INSERT INTO `ESTUDIANTE` VALUES (201,'Filippo','Galli','Calle 1','Informática','22'),(202,'Laura','González','Calle 2','Informática','24'),(203,'Marcos','Pérez','Calle 3','Biología','21'),(204,'Juliana','García','Calle 4','Historia','20'),(205,'Luis','Ramírez','Calle 5','Informática','25');

INSERT INTO libro (titulo, editorial, area) VALUES
('Cien Años de Soledad', 'Sudamericana', 'Literatura'),
('La Casa de los Espíritus', 'Plaza & Janés', 'Literatura'),
('Ficciones', 'Emecé', 'Base de Datos'),
('Conversación en La Catedral', 'Alfaguara', 'Política'),
('Soporte Vital Avanzado', 'Salamandra', 'Política'),
('El Universo: Guía de viaje', 'Salamandra', 'Política'),
('Harry Potter Saga', 'JK', 'Literatura'),
('Rayuela', 'Sudamericana', 'Narrativa');

-- Se asume que los libros y autores tienen IDs del 1 al 5
INSERT INTO libro_autor (id_libro, id_autor) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(6, 1),
(6, 2),
(7, 6),
(5, 5);

-- Se asume que estudiantes tienen IDs del 1 al 5 y libros también
INSERT INTO prestamo (id_libro, id_estudiante, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, NOW(), NULL, FALSE),
(2, 2, '2025-05-01 10:00:00', '2025-05-10 10:00:00', TRUE),
(3, 3, '2025-05-05 09:00:00', NULL, FALSE),
(4, 4, '2025-04-15 11:00:00', '2025-04-22 11:00:00', TRUE),
(5, 201, '2021-06-16 15:00:00', '2021-07-16', FALSE),
(1, 201, '2025-05-10 15:00:00', NULL, FALSE),
(5, 5, '2025-05-10 15:00:00', NULL, FALSE);


-- En base al mismo, plantear las consultas SQL para resolver los siguientes requerimientos:

-- 1. Listar los datos de los autores.
SELECT * FROM autor;

-- 2. istar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera LIKE 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad IN ('Francesa', 'Italiana');

-- 5. ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area NOT LIKE 'Internet';

-- 6. Listar los libros de la editorial Salamandra.

SELECT * FROM libro WHERE editorial LIKE 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * 
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre
FROM estudiante
WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a JOIN libro_autor la 
ON a.id = la.id_autor
JOIN libro l ON l.id = la.id_libro
WHERE l.titulo LIKE 'El Universo: Guía de viaje';

-- 10.  ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo
FROM estudiante e JOIN prestamo p ON e.id = p.id_estudiante
JOIN libro l ON l.id = p.id_libro
WHERE e.nombre LIKE 'Filippo' AND e.apellido LIKE 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT *
FROM estudiante
ORDER BY edad
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM estudiante e
JOIN prestamo p ON e.id = p.id_estudiante
JOIN libro l ON p.id_libro = l.id
WHERE l.area = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo
FROM autor a JOIN libro_autor la ON a.id = la.id_autor
JOIN libro l ON l.id = la.id_libro
WHERE a.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libro l JOIN prestamo p ON l.id = p.id_libro
WHERE fecha_devolucion = '2021-07-16';

