-- Crear la base de datos
CREATE DATABASE biblioteca;
USE biblioteca;

-- Crear tabla libro
CREATE TABLE libro (
  idLibro INT PRIMARY KEY,
  titulo VARCHAR(50),
  editorial VARCHAR(50),
  area VARCHAR(50)
);

-- Crear tabla autor
CREATE TABLE autor (
  idAutor INT PRIMARY KEY,
  nombre VARCHAR(50),
  nacionalidad VARCHAR(50)
);

-- Crear tabla libroAutor con clave primaria compuesta (idAutor, idLibro)
CREATE TABLE libroAutor (
  idAutor INT,
  idLibro INT,
  PRIMARY KEY (idAutor, idLibro),
  FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
  FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

-- Crear tabla estudiante
CREATE TABLE estudiante (
  idLector INT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  direccion VARCHAR(50),
  carrera VARCHAR(50),
  edad INT
);

-- Crear tabla prestamo con clave primaria compuesta (idLector, idLibro)
CREATE TABLE prestamo (
  idLector INT,
  idLibro INT,
  fechaPrestamo DATE,
  fechaDevolucion DATE,
  devuelto BOOL,
  PRIMARY KEY (idLector, idLibro),
  FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
  FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

-- Se definen 5 libros
INSERT INTO libro (idLibro, titulo, editorial, area) VALUES 
(1, 'Cien Años de Soledad', 'Editorial Sudamericana', 'Novela'),
(2, 'Ficciones', 'Planeta', 'Cuentos'),
(3, 'Don Quijote de la Mancha', 'Francisco de Robles', 'Literatura'),
(4, 'Rayuela', 'Siglo XXI', 'Novela'),
(5, 'La Casa de los Espíritus', 'Editorial Sudamericana', 'Novela');

-- Se definen 5 autores
INSERT INTO autor (idAutor, nombre, nacionalidad) VALUES 
(1, 'Gabriel García Márquez', 'Colombiano'),
(2, 'Jorge Luis Borges', 'Argentino'),
(3, 'Miguel de Cervantes', 'Español'),
(4, 'Julio Cortázar', 'Argentino'),
(5, 'Isabel Allende', 'Chilena');

-- Se asigna cada libro a su respectivo autor
INSERT INTO libroAutor (idAutor, idLibro) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Insertar registros en la tabla estudiante
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Pérez', 'Calle 1', 'Ingeniería', 22),
(2, 'María', 'Gómez', 'Calle 2', 'Medicina', 24),
(3, 'Pedro', 'López', 'Calle 3', 'Derecho', 21),
(4, 'Ana', 'Martínez', 'Calle 4', 'Arquitectura', 23),
(5, 'Luis', 'González', 'Calle 5', 'Economía', 25);

-- Se realizan 5 préstamos (relacionando idLector e idLibro existentes)
INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2023-01-10', '2023-01-20', TRUE),
(2, 2, '2023-01-12', '2023-01-22', FALSE),
(3, 3, '2023-01-15', '2023-01-25', TRUE),
(4, 4, '2023-01-18', '2023-01-28', TRUE),
(5, 5, '2023-01-20', '2023-01-30', FALSE);