CREATE DATABASE biblioteca_db;
USE biblioteca_db;

CREATE TABLE LIBRO (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	titulo VARCHAR(255),
	editorial VARCHAR(255),
	area VARCHAR(255)
);

CREATE TABLE ESTUDIANTE (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	nombre VARCHAR(255) NOT NULL,
	apellido VARCHAR(255) NOT NULL,
	direccion VARCHAR(255),
	carrera VARCHAR(255),
	edad INT
);

CREATE TABLE AUTOR (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	nombre VARCHAR(255) NOT NULL,
	nacionalidad VARCHAR(255) NOT NULL
);

CREATE TABLE LIBRO_AUTOR (
    id_autor INT,
    id_libro INT,
    PRIMARY KEY (id_autor, id_libro),
    FOREIGN KEY (id_autor) REFERENCES AUTOR(id),
    FOREIGN KEY (id_libro) REFERENCES LIBRO(id)
);

CREATE TABLE PRESTAMO (
    id_estudiante INT,
    id_libro INT,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    PRIMARY KEY (id_estudiante, id_libro, fecha_prestamo),
    FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTE(id),
    FOREIGN KEY (id_libro) REFERENCES LIBRO(id)
);

INSERT INTO AUTOR (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('J.K. Rowling', 'Británica'),
('Isaac Asimov', 'Americana'),
('George Orwell', 'Británica'),
('Mario Vargas Llosa', 'Peruana'),
('Oliver Berry', 'Británica'),
('Mark A. Garlick', 'Británica'),
('Mark Mackenzie', 'Británica'),
('Valerie Stimac', 'Americana'),
('Isaac Asimov', 'Americana'),
('Ernest Hemingway', 'Americana'),
('Victor Hugo', 'Francesa'),
('Umberto Eco', 'Italiana');

INSERT INTO LIBRO (titulo, editorial, area) VALUES
('Cien años de soledad', 'Editorial Sudamericana', 'Literatura'),
('Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
('Fundación', 'Editorial Planeta', 'Ciencia Ficción'),
('1984', 'Editorial Seix Barral', 'Distopía'),
('La ciudad y los perros', 'Editorial Alfaguara', 'Literatura'),
('El Universo: Guía de viaje', 'Salamandra', 'Ciencia'),
('El arte de la guerra', 'Editorial Random House', 'Historia'),
('La historia interminable', 'Editorial Grijalbo', 'Fantasía'),
('Estructuras de Datos', 'Salamandra', 'Base de Datos');

INSERT INTO ESTUDIANTE (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 17),
('María', 'Gómez', 'Avenida Libertad 456', 'Literatura', 21),
('Luis', 'Martínez', 'Calle Real 789', 'Filosofía', 22),
('Ana', 'Hernández', 'Boulevard Central 321', 'Ciencias Sociales', 19),
('Pedro', 'Rodríguez', 'Avenida del Sol 654', 'Matemáticas', 23),
('Filippo', 'Galli', 'Calle del Río 111', 'Informatica', 24),
('Cecilia', 'Gómez', 'Calle Estrella 222', 'Informatica', 18),
('Emilio', 'Fernández', 'Calle Azul 333', 'Historia', 25);

INSERT INTO LIBRO_AUTOR (id_autor, id_libro) VALUES
(1, 1),  -- Gabriel García Márquez, "Cien años de soledad"
(2, 2),  -- J.K. Rowling, "Harry Potter y la piedra filosofal"
(3, 3),  -- Isaac Asimov, "Fundación"
(4, 4),  -- George Orwell, "1984"
(5, 5),  -- Mario Vargas Llosa, "La ciudad y los perros"
(6, 6),  -- Oliver Berry, "El Universo: Guía de viaje"
(7, 6),  -- Mark A. Garlick, "El Universo: Guía de viaje"
(8, 6),  -- Mark Mackenzie, "El Universo: Guía de viaje"
(9, 6);  -- Valerie Stimac, "El Universo: Guía de viaje"

INSERT INTO PRESTAMO (id_estudiante, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2023-10-01', '2023-10-15', TRUE),
(2, 2, '2023-10-02', '2023-10-16', FALSE),
(3, 3, '2023-10-03', '2023-10-17', TRUE),
(4, 4, '2023-10-04', NULL, FALSE),  -- Libros no devueltos
(5, 5, '2023-10-05', '2023-10-20', TRUE),
(6, 9, '2021-07-01', '2021-07-16', TRUE), -- Libro devuelto
(7, 6, '2021-06-15', '2021-06-30', TRUE),
(8, 8, '2021-07-10', NULL, FALSE);


