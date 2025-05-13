CREATE TABLE autor (
    idAutor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(50)
);

CREATE TABLE libro (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150),
    editorial VARCHAR(100),
    area VARCHAR(50)
);

CREATE TABLE libroAutor (
    idAutor INT,
    idLibro INT,
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

CREATE TABLE estudiante (
    idLector INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    direccion VARCHAR(200),
    carrera VARCHAR(100),
    edad INT
);

CREATE TABLE prestamo (
    idLector INT,
    idLibro INT,
    fechaPrestamo DATE,
    fechaDevolucion DATE,
    devuelto BOOLEAN,
    FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

INSERT INTO autor (Nombre, Nacionalidad) VALUES 
('J.K. Rowling', 'Británica'),
('Gabriel García Márquez', 'Colombiana'),
('Victor Hugo', 'Francesa'),
('Umberto Eco', 'Italiana'),
('Isabel Allende', 'Chilena');

INSERT INTO libro (Titulo, Editorial, Area) VALUES 
('Harry Potter', 'Salamandra', 'Fantasía'),
('Cien Años de Soledad', 'Sudamericana', 'Literatura'),
('Los Miserables', 'Penguin', 'Clásicos'),
('El Nombre de la Rosa', 'Debolsillo', 'Historia'),
('La Casa de los Espíritus', 'Plaza & Janés', 'Narrativa');

INSERT INTO libroAutor (idAutor, idLibro) VALUES 
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 5);

INSERT INTO estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES 
('Filippo', 'Galli', 'Calle Falsa 123', 'Informática', 20),
('Carmen', 'González', 'Av. Libertador 456', 'Literatura', 22),
('Lucas', 'Gómez', 'Calle Principal 789', 'Historia', 25),
('María', 'Gutierrez', 'Callejón 101', 'Narrativa', 19),
('Ana', 'Garcia', 'Plaza Mayor 202', 'Informática', 23);

INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES 
(1, 1, '2021-07-01', '2021-07-16', TRUE),
(2, 2, '2021-06-15', '2021-06-30', FALSE),
(3, 3, '2021-08-01', '2021-08-20', TRUE),
(4, 4, '2021-09-10', '2021-09-25', TRUE),
(5, 5, '2021-10-01', '2021-10-15', FALSE);

SELECT * FROM AUTOR;
SELECT * FROM LIBRO;
SELECT * FROM LIBROAUTOR;
SELECT * FROM ESTUDIANTE;
SELECT * FROM PRESTAMO;

/*1. Listar los datos de los autores.*/
SELECT * 
FROM autor;

/*2. Listar nombre y edad de los estudiantes*/
SELECT nombre, edad
FROM estudiante;

/*3. ¿Qué estudiantes pertenecen a la carrera informática?*/
SELECT nombre
FROM estudiante
WHERE carrera = 'Informática';

/*4. ¿Qué autores son de nacionalidad francesa o italiana?*/
SELECT nombre
FROM autor
WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';

/*5. ¿Qué libros no son del área de internet?*/
SELECT titulo
FROM libro
WHERE area <> 'Internet';

/*6. Listar los libros de la editorial Salamandra.*/
SELECT titulo
FROM libro 
WHERE editorial = 'Salamandra';

/*7. Listar los datos de los estudiantes cuya edad es mayor al promedio.*/
SELECT * 
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

/*8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.*/
SELECT nombre,apellido
FROM estudiante
WHERE apellido LIKE 'G%';

/*9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).*/
SELECT a.nombre
FROM autor a
JOIN libroAutor la ON a.idAutor = la.idAutor
JOIN libro l ON la.idLibro = l.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje';

/*10. ¿Qué libros se prestaron al lector “Filippo Galli”?*/
SELECT l.titulo
FROM libro l
JOIN prestamo p ON p.idLibro = l.idLibro
JOIN estudiante e ON e.idLector = p.idLibro
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

/*11. Listar el nombre del estudiante de menor edad.*/
SELECT nombre
FROM estudiante 
WHERE edad = (SELECT MIN(edad) FROM estudiante);

/*12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.*/
SELECT e.nombre
FROM estudiante e
JOIN prestamo p ON e.idLector = p.idLector
JOIN libro l ON l.idLibro = p.idLibro
WHERE l.area = 'Base de Datos';

/*13. Listar los libros que pertenecen a la autora J.K. Rowling.*/
SELECT l.titulo
FROM libro l
JOIN libroAutor la ON la.idLibro = l.idLibro
JOIN autor a ON a.idAutor = la.idAutor
WHERE  a.nombre = 'J.K. Rowling';

/*14. Listar títulos de los libros que debían devolverse el 16/07/2021.*/
SELECT l.titulo
FROM libro l
JOIN prestamo p ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion = '2021-07-16';





