CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE `libro` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `titulo` varchar(50),
  `editorial` varchar(20),
  `area` varchar(20)
);

CREATE TABLE `libro_autor` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `id_autor` integer,
  `id_libro` integer
);

CREATE TABLE `autor` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(30),
  `nacionalidad` varchar(20)
);

CREATE TABLE `prestamo` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `fecha_prestamo` date,
  `fecha_devolucion` date,
  `devuelto` boolean,
  `id_libro` integer,
  `id_lector` integer
);

CREATE TABLE `estudiante` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(20),
  `apellido` varchar(20),
  `direccion` varchar(50),
  `carrera` varchar(30),
  `edad` int
);

ALTER TABLE `libro_autor` ADD FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id`);

ALTER TABLE `libro_autor` ADD FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id`);

ALTER TABLE `prestamo` ADD FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id`);

ALTER TABLE `prestamo` ADD FOREIGN KEY (`id_lector`) REFERENCES `estudiante` (`id`);

INSERT INTO libro (titulo, editorial, area) VALUES
('Cien años de soledad', 'Sudamericana', 'Literatura'),
('El origen de las especies', 'Penguin', 'Ciencia'),
('Crónica de una muerte anunciada', 'Sudamericana', 'Literatura'),
('El arte de la guerra', 'Planeta', 'Historia'),
('Física para universitarios', 'McGraw-Hill', 'Educación');

INSERT INTO autor (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('Charles Darwin', 'Británica'),
('Sun Tzu', 'China'),
('Stephen Hawking', 'Británica'),
('Mario Vargas Llosa', 'Peruana');

INSERT INTO libro_autor (id_autor, id_libro) VALUES
(1, 1), -- Gabriel García Márquez → Cien años de soledad
(2, 2), -- Charles Darwin → El origen de las especies
(1, 3), -- Gabriel García Márquez → Crónica de una muerte anunciada
(3, 4), -- Sun Tzu → El arte de la guerra
(4, 5); -- Stephen Hawking → Física para universitarios

INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Lucía', 'Pérez', 'Calle 123', 'Ingeniería', 22),
('Martín', 'Gómez', 'Av. Central 45', 'Historia', 24),
('Ana', 'Rodríguez', 'Pasaje Sur 89', 'Literatura', 21),
('Luis', 'Fernández', 'Calle Norte 12', 'Biología', 23),
('Valeria', 'Suárez', 'Diagonal Este 33', 'Física', 22);

INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, devuelto, id_libro, id_lector) VALUES
('2024-09-01', '2024-09-10', TRUE, 1, 1),
('2024-09-03', '2024-09-12', TRUE, 2, 2),
('2024-09-05', '2024-09-15', FALSE, 3, 3),
('2024-09-07', '2024-09-17', FALSE, 4, 4),
('2024-09-09', '2024-09-19', TRUE, 5, 5);

/*Listar los datos de los autores.*/
SELECT * FROM autor;

/*Listar nombre y edad de los estudiantes*/
SELECT nombre, edad
FROM estudiante;

/*¿Qué estudiantes pertenecen a la carrera Ingeniería?*/
SELECT nombre, carrera
FROM estudiante
WHERE carrera LIKE '%Ingeniería%';

/*¿Qué autores son de nacionalidad británica o china?*/
SELECT *
FROM autor
WHERE nacionalidad LIKE '%Británica%' 
OR nacionalidad LIKE '%China%';

/*¿Qué libros no son del área de Literatura?*/
SELECT *
FROM libro
WHERE area NOT LIKE '%Literatura%';

/*Listar los libros de la editorial Planeta.*/
SELECT *
FROM libro
WHERE editorial LIKE '%Planeta%';

/*Listar los datos de los estudiantes cuya edad es mayor al promedio.*/
SELECT nombre, apellido, direccion, carrera, edad
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

/*Listar los nombres de los estudiantes cuyo apellido comience con la letra G.*/
SELECT nombre
FROM estudiante
WHERE apellido LIKE 'G%';

/*Listar los autores del libro "Cien años de soledad”. (Se debe listar solamente los nombres).*/
SELECT a.nombre, a.nacionalidad
FROM autor a JOIN libro_autor la ON a.id = la.id_autor
JOIN libro l ON l.id = la.id_libro
WHERE l.titulo LIKE '%Cien años de soledad%';

/*¿Qué libros se prestaron al lector “Lucía Perez”?*/
SELECT l.titulo 
FROM libro l JOIN prestamo p ON l.id = p.id_libro
JOIN estudiante e ON e.id = p.id_lector
WHERE e.nombre LIKE '%Lucía%' AND e.apellido LIKE '%Perez%';

/*Listar el nombre del estudiante de menor edad.*/
SELECT nombre
FROM estudiante 
ORDER BY edad ASC
LIMIT 1;

/*Listar nombres de los estudiantes a los que se prestaron libros de Historia.*/
SELECT e.nombre
FROM estudiante e
JOIN prestamo p ON e.id = p.id_lector
JOIN libro l ON l.id = p.id_libro
WHERE l.area LIKE '%Historia%';

/*Listar los libros que pertenecen a la autora Charles Darwin.*/
SELECT l.titulo, l.editorial, l.area
FROM libro l JOIN libro_autor la 
ON l.id = la.id_libro
JOIN autor a ON la.id_autor = a.id
WHERE a.nombre LIKE '%Charles Darwin%';

/*Listar títulos de los libros que debían devolverse el 10/09/2024.*/
SELECT l.titulo
FROM libro l JOIN prestamo p 
ON l.id = p.id_libro
WHERE p.fecha_devolucion = '20240910';



