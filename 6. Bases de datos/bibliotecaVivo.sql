DROP SCHEMA IF EXISTS `biblioteca`;
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE AUTOR (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Nacionalidad VARCHAR(100)
);

CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(255),
    Editorial VARCHAR(100),
    Area VARCHAR(100)
);

CREATE TABLE ESTUDIANTE (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Apellido VARCHAR(100),
    Direccion VARCHAR(255),
    Carrera VARCHAR(100),
    Edad INT
);

CREATE TABLE PRESTAMO (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

CREATE TABLE LIBROAUTOR (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

INSERT INTO AUTOR (Nombre, Nacionalidad) VALUES
('J.K. Rowling', 'Británica'),
('Gabriel García Márquez', 'Colombiana'),
('George Orwell', 'Británica'),
('Victor Hugo', 'Francés'),
('Italo Calvino', 'Italiano');

INSERT INTO LIBRO (Titulo, Editorial, Area) VALUES
('El Universo: Guía de viaje', 'Planeta', 'Ciencia'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('Cien años de soledad', 'Editorial Oveja Negra', 'Ficción'),
('1984', 'Debolsillo', 'Ficción'),
('El túnel', 'Anagrama', 'Literatura'),
('El Hobbit', 'Salamandra', 'Fantasía'),
('La historia interminable', 'Salamandra', 'Fantasía'),
('La Ilíada', 'Ediciones Akal', 'Literatura'),
('Fundamentos de Bases de Datos', 'Pearson', 'Internet');

INSERT INTO ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad) VALUES
('Filippo', 'Galli', 'Via Roma 123', 'Informática', 22),
('María', 'Gonzalez', 'Calle Sol 24', 'Ingeniería', 25),
('Lucas', 'Martin', 'Calle Azul 78', 'Informática', 21),
('Ana', 'Gómez', 'Calle Verde 56', 'Biología', 23),
('Sofía', 'López', 'Calle Estrella 10', 'Informática', 20),
('Pedro', 'García', 'Calle Luna 15', 'Matemáticas', 30);

INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 5, '2021-06-01', '2021-06-15', TRUE),
(2, 4, '2021-07-01', '2021-07-10', TRUE),
(1, 9, '2021-07-01', '2021-07-16', TRUE),
(3, 1, '2021-07-05', NULL, FALSE),
(4, 3, '2021-06-15', '2021-06-30', TRUE),
(5, 2, '2021-06-21', NULL, FALSE);

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 2),
(2, 3),
(1, 1),
(3, 4),
(4, 3),
(5, 5);

-- 1
SELECT * 
FROM AUTOR;
-- 2
SELECT e.nombre, e.edad 
FROM ESTUDIANTE e;
-- 3
SELECT * 
FROM ESTUDIANTE 
WHERE carrera LIKE 'Informática';
-- 4
SELECT * 
FROM AUTOR 
WHERE nacionalidad LIKE 'Francés' OR nacionalidad LIKE 'Italiano';
-- 5
SELECT * 
FROM LIBRO 
WHERE area NOT LIKE 'Internet';
-- 6
SELECT * 
FROM LIBRO 
WHERE editorial LIKE 'Salamandra';
-- 7
SELECT * 
FROM ESTUDIANTE 
WHERE edad > (SELECT AVG(edad) FROM ESTUDIANTE);
-- 8
SELECT e.nombre 
FROM ESTUDIANTE e 
WHERE Apellido LIKE 'G%';
-- 9
SELECT a.nombre 
FROM AUTOR a 
JOIN LIBROAUTOR la ON a.idAutor = la.idAutor 
JOIN LIBRO l ON la.idLibro = l.idLibro 
WHERE l.titulo = 'El Universo: Guía de viaje';
-- 10 
SELECT l.titulo 
FROM LIBRO l 
JOIN PRESTAMO p ON l.idLibro = p.idLibro 
WHERE p.idLector = (SELECT idLector FROM ESTUDIANTE WHERE nombre = 'Filippo' AND apellido = 'Galli');
-- 11
SELECT nombre FROM ESTUDIANTE ORDER BY edad ASC LIMIT 1;
-- 12
SELECT e.nombre 
FROM ESTUDIANTE e 
JOIN PRESTAMO p ON e.idLector = p.idLector 
JOIN LIBRO l ON p.idLibro = l.idLibro 
WHERE l.titulo = 'Fundamentos de Bases de Datos';
-- 13
SELECT l.titulo 
FROM LIBRO l 
JOIN LIBROAUTOR la ON l.idLibro = la.idLibro 
WHERE la.idAutor = (SELECT idAutor FROM AUTOR WHERE nombre = 'J.K. Rowling');
-- 14
SELECT l.titulo 
FROM LIBRO l 
JOIN PRESTAMO p ON l.idLibro = p.idLibro 
WHERE p.fechaDevolucion = '2021-07-16';

