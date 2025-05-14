DROP DATABASE IF EXISTS biblioteca_test;
CREATE DATABASE biblioteca_test;
USE biblioteca_test;

-- Tabla LIBRO
CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    titulo VARCHAR(100),
    editorial VARCHAR(50),
    area VARCHAR(50)
);

-- Tabla AUTOR
CREATE TABLE autor (
    idAutor INT PRIMARY KEY,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(50)
);

-- Tabla LIBROAUTOR
CREATE TABLE libroautor (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);


-- Tabla ESTUDIANTE
CREATE TABLE estudiante (
    idLector INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    dirección VARCHAR(100),
    carrera VARCHAR(50),
    edad INT
);

-- Tabla PRESTAMO
CREATE TABLE prestamo (
    idLector INT,
    idLibro INT,
    fechaPrestamo DATE,
    fechaDevolucion DATE,
    devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

-- LIBRO
INSERT INTO libro VALUES
(1, 'Introducción a SQL', 'McGraw-Hill', 'Bases de Datos'),
(2, 'Estructuras de Datos', 'Pearson', 'Programación'),
(3, 'Fundamentos de Redes', 'Alfaomega', 'Redes'),
(4, 'Programación en Python', 'Anaya', 'Internet'),
(5, 'Cálculo Diferencial', 'Trillas', 'Matemáticas');

-- AUTOR
INSERT INTO autor VALUES
(1, 'Carlos Pérez', 'Colombiana'),
(2, 'Ana Gómez', 'Argentina'),
(3, 'Luis Torres', 'Mexicana'),
(4, 'Marta Ríos', 'Peruana'),
(5, 'Andrés Herrera', 'Chilena');

-- LIBROAUTOR
INSERT INTO libroautor VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 2),   -- Carlos Pérez también participó en el libro 2
(2, 4);   -- Ana Gómez también participó en el libro 4

-- ESTUDIANTE
INSERT INTO ESTUDIANTE VALUES
(100, 'Filippo', 'Galli', 'Calle 123', 'Informática', 21),
(101, 'Gabriel', 'Ramírez', 'Avenida 45', 'Matemáticas', 22),
(102, 'Andrea', 'López', 'Cra 45 #12', 'Ingeniería Electrónica', 20),
(103, 'Carlos', 'Díaz', 'Calle 89 #21', 'Física', 23),
(104, 'Valeria', 'Suárez', 'Av. Siempre Viva 742', 'Matemáticas', 22),
(105, 'Julián', 'Reyes', 'Calle Luna 77', 'Informática', 24);

-- PRESTAMO
INSERT INTO PRESTAMO VALUES
(100, 1, '2025-05-01', '2025-05-10', TRUE),
(101, 2, '2025-05-05', NULL, FALSE),
(102, 3, '2025-05-03', '2025-05-15', TRUE),
(103, 4, '2025-05-07', NULL, FALSE),
(104, 2, '2025-04-20', '2025-04-27', TRUE),
(105, 5, '2025-05-08', NULL, FALSE),
(100, 5, '2025-05-10', NULL, FALSE);

# Listar los datos de los autores.
SELECT * FROM autor;

# Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM estudiante
WHERE carrera = 'Informática';

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM autor
WHERE nacionalidad IN ("Francesa", "Italiana");

# ¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE area NOT IN ("Internet");

# Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE editorial = "Salamandra";

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) from estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT *
FROM estudiante
WHERE apellido LIKE "G%";

# Listar los autores del libro “El Universo: Guía de viaje”. 
SELECT a.idAutor, a.Nombre, a.Nacionalidad
FROM autor a
INNER JOIN libroautor la on a.idAutor = la.idAutor
INNER JOIN libro l on l.idLibro = la.idLibro
WHERE titulo = "El Universo: Guía de viaje";

# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.idLibro, l.titulo
FROM libro l
INNER JOIN prestamo p ON l.idLibro = p.idLibro
INNER JOIN estudiante e ON e.idLector = p.idLector
WHERE e.nombre = "Filippo" AND e.apellido = "Galli";

# Listar el nombre del estudiante de menor edad.
SELECT *
FROM estudiante
ORDER BY edad
LIMIT 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM libro l
INNER JOIN prestamo p ON l.idLibro = p.idLibro
INNER JOIN estudiante e ON e.idLector = p.idLector
WHERE l.area = "Bases de Datos";

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT *
FROM autor a
INNER JOIN libroautor la on a.idAutor = la.idAutor
INNER JOIN libro l on l.idLibro = la.idLibro
WHERE nombre = "J.K. Rowling";

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT *
FROM libro l
INNER JOIN prestamo p ON l.idLibro = p.idLibro
WHERE fechaDevolucion = "2021-07-16";

