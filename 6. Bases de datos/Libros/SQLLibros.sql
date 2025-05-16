CREATE DATABASE IF NOT EXISTS Biblioteca;
USE Biblioteca;

-- ELIMINAR TABLAS EN ORDEN INVERSO A SUS DEPENDENCIAS
DROP TABLE IF EXISTS Prestamo;
DROP TABLE IF EXISTS LibroAutor;
DROP TABLE IF EXISTS Estudiante;
DROP TABLE IF EXISTS Libro;
DROP TABLE IF EXISTS Autor;

-- TABLA AUTOR
CREATE TABLE Autor (
    idAutor INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Nacionalidad VARCHAR(50)
);

-- TABLA LIBRO
CREATE TABLE Libro (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(100),
    Editorial VARCHAR(50),
    Area VARCHAR(50)
);

-- TABLA LIBROAUTOR (relación N a N entre libro y autor)
CREATE TABLE LibroAutor (
    idLibro INT,
    idAutor INT,
    PRIMARY KEY (idLibro, idAutor),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro),
    FOREIGN KEY (idAutor) REFERENCES Autor(idAutor)
);

-- TABLA ESTUDIANTE
CREATE TABLE Estudiante (
    idLector INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Direccion VARCHAR(100),
    Carrera VARCHAR(50),
    Edad INT
);

-- TABLA PRESTAMO
CREATE TABLE Prestamo (
    idLector INT,
    idLibro INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    Devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro, FechaPrestamo),
    FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);
-- AUTORES
INSERT INTO Autor VALUES (1, 'Jorge Luis Borges', 'Argentina');
INSERT INTO Autor VALUES (2, 'Gabriel García Márquez', 'Colombia');
INSERT INTO Autor VALUES (3, 'Isabel Allende', 'Chile');
INSERT INTO Autor VALUES (4, 'Mario Vargas Llosa', 'Perú');
INSERT INTO Autor VALUES (5, 'Julio Cortázar', 'Argentina');
INSERT INTO Autor VALUES (6, 'Italo Calvino', 'Italia');
INSERT INTO Autor VALUES (7, 'Victor Hugo', 'Francia');
INSERT INTO Autor VALUES (8, 'Carlo Rovelli', 'Italia');
INSERT INTO Autor VALUES (9, 'J.K. Rowling', 'USA');


-- LIBROS
INSERT INTO Libro VALUES (101, 'Ficciones', 'Salamandra', "online");
INSERT INTO Libro VALUES (102, 'Cien años de soledad', 'Sudamericana', 'físico');
INSERT INTO Libro VALUES (103, 'La casa de los espíritus', 'Plaza & Janés', 'online');
INSERT INTO Libro VALUES (104, 'La ciudad y los perros', 'Alfaguara', 'físico');
INSERT INTO Libro VALUES (105, 'Base de Datos', 'Sudamericana', 'físico');
INSERT INTO Libro VALUES (106, 'El Universo: Guía de viaje', 'Planeta', 'Ciencia');
INSERT INTO Libro VALUES (201, 'Harry Potter y la piedra filosofal', 'Planeta', 'Ciencia');
INSERT INTO Libro VALUES (202, 'Harry Potter y la cámara secreta', 'Planeta', 'Ciencia');
INSERT INTO Libro VALUES (203, 'Harry Potter y el prisionero de Azkaban', 'Planeta', 'Ciencia');




-- RELACIÓN LIBROAUTOR
INSERT INTO LibroAutor VALUES (101, 1);
INSERT INTO LibroAutor VALUES (102, 2);
INSERT INTO LibroAutor VALUES (103, 3);
INSERT INTO LibroAutor VALUES (104, 4);
INSERT INTO LibroAutor VALUES (105, 5);
INSERT INTO LibroAutor VALUES (106, 7);
INSERT INTO LibroAutor VALUES (106, 8);
INSERT INTO LibroAutor VALUES (201, 9);
INSERT INTO LibroAutor VALUES (202, 9);
INSERT INTO LibroAutor VALUES (203, 9);


-- ESTUDIANTES
INSERT INTO Estudiante VALUES (1001, 'Ana', 'Pérez', 'Calle 123', 'Ingeniería', 21);
INSERT INTO Estudiante VALUES (1002, 'Luis', 'Gómez', 'Av. Siempreviva 742', 'Medicina', 22);
INSERT INTO Estudiante VALUES (1003, 'Filippo', 'Galli', 'San Martín 123', 'Derecho', 23);
INSERT INTO Estudiante VALUES (1004, 'Pedro', 'Fernández', 'Corrientes 456', 'Arquitectura', 20);
INSERT INTO Estudiante VALUES (1005, 'Lucía', 'Rodríguez', 'Belgrano 789', 'Informática', 24);

-- PRÉSTAMOS
INSERT INTO Prestamo VALUES (1001, 101, '2024-05-01', '2024-05-10', TRUE);
INSERT INTO Prestamo VALUES (1002, 102, '2024-05-03', '2024-05-12', FALSE);
INSERT INTO Prestamo VALUES (1003, 103, '2024-05-05', '2024-05-15', TRUE);
INSERT INTO Prestamo VALUES (1004, 104, '2024-05-07', '2024-05-17', FALSE);
INSERT INTO Prestamo VALUES (1005, 105, '2024-05-09', '2024-05-19', TRUE);
INSERT INTO Prestamo VALUES (1001, 101, '2021-07-01', '2021-07-16', FALSE);


