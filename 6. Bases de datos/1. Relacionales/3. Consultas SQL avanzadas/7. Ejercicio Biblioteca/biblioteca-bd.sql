--
-- DDL
--

-- Crear la base de datos
CREATE DATABASE biblioteca;
USE biblioteca;

-- Tabla autor
CREATE TABLE autor (
    id_autor INT PRIMARY KEY,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(50)
);

-- Tabla libro
CREATE TABLE libro (
    id_libro INT PRIMARY KEY,
    titulo VARCHAR(200),
    editorial VARCHAR(100),
    area VARCHAR(100)
);

-- Tabla estudiante
CREATE TABLE estudiante (
    id_lector INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    direccion VARCHAR(200),
    carrera VARCHAR(100),
    edad INT
);

-- Tabla prestamo
CREATE TABLE prestamo (
    id_lector INT,
    id_libro INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    PRIMARY KEY (id_lector, id_libro),
    FOREIGN KEY (id_lector) REFERENCES estudiante(id_lector),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

-- Tabla libro_autor
CREATE TABLE libro_autor (
    id_autor INT,
    id_libro INT,
    PRIMARY KEY (id_autor, id_libro),
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

--
-- DML
--

-- Insertar datos en la tabla autor
INSERT INTO autor (id_autor, nombre, nacionalidad) VALUES
(1, 'Isaac Asimov', 'rusa'),
(2, 'J.K. Rowling', 'británica'),
(3, 'George Orwell', 'británica'),
(4, 'Charles Baudelaire', 'francesa'),
(5, 'Italo Calvino', 'italiana');

-- Insertar datos en la tabla libro
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES
(1, '1984', 'Penguin', 'ciencia política'),
(2, 'Harry Potter', 'Bloomsbury', 'fantasía'),
(3, 'El Universo: Guía de viaje', 'Salamandra', 'ciencia'),
(4, 'Fundación', 'Gnome Press', 'ciencia ficción'),
(5, 'Invisible Cities', 'Harcourt Brace', 'literatura'),
(6, 'Internet for Dummies', 'Wiley', 'internet');

INSERT INTO libro (id_libro, titulo, editorial, area) VALUES
(7, 'Introducción a Base de Datos', 'Pearson', 'Base de Datos');

-- Insertar datos en la tabla estudiante
INSERT INTO estudiante (id_lector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Perez', 'Calle Falsa 123', 'informática', 20),
(2, 'Lucia', 'Gimenez', 'Avenida Siempre Viva 742', 'literatura', 21),
(3, 'Filippo', 'Galli', 'Viale dei Mille 11', 'informática', 22),
(4, 'Ana', 'Garcia', 'Boulevard de la Mer 10', 'informática', 23);

-- Insertar datos en la tabla prestamo
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2021-06-14', '2021-07-16', TRUE),
(2, 2, '2021-06-20', '2021-07-18', FALSE),
(3, 3, '2021-06-25', '2021-07-16', TRUE),
(3, 4, '2021-07-01', '2021-08-01', FALSE),
(4, 5, '2021-05-15', '2021-06-15', TRUE);

INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(2, 7, '2023-07-10', '2023-08-10', FALSE);

-- Insertar datos en la tabla libro_autor
INSERT INTO libro_autor (id_autor, id_libro) VALUES
(1, 4),
(2, 2),
(3, 1),
(4, 3),
(5, 5);