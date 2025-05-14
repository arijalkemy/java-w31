
-- INSERTAR DATOS TABLA AUTOR
INSERT INTO AUTOR (id_autor, nombre, nacionalidad) VALUES
(1, 'Gabriel García Márquez', 'Colombiana'),
(2, 'Julio Cortázar', 'Argentina'),
(3, 'Isabel Allende', 'Chilena'),
(4, 'Mario Vargas Llosa', 'Peruana');

-- INSERTAR DATOS TABLA LIBRO
INSERT INTO LIBRO (id_libro, titulo, editorial, area) VALUES
(101, 'Cien años de soledad', 'Sudamericana', 'Literatura'),
(102, 'Rayuela', 'Alfaguara', 'Literatura'),
(103, 'La casa de los espíritus', 'Plaza & Janés', 'Ficción'),
(104, 'La ciudad y los perros', 'Seix Barral', 'Novela'),
(105, 'Crónica de una muerte anunciada', 'Sudamericana', 'Periodismo');

-- INSERTAR DATOS TABLA LIBRO_AUTOR
INSERT INTO LIBRO_AUTOR (id_autor, id_libro) VALUES
(1, 101),
(1, 105),
(2, 102),
(3, 103),
(4, 104);

-- INSERTAR DATOS TABLA ESTUDIANTE
INSERT INTO ESTUDIANTE (id_lector, nombre, apellido, direccion, carrera, edad) VALUES
(201, 'Laura', 'Martínez', 'Calle Falsa 123', 'Ingeniería', 22),
(202, 'Carlos', 'Ramírez', 'Av. Siempre Viva 742', 'Derecho', 24),
(203, 'Ana', 'López', 'Diagonal 80 N°456', 'Literatura', 21),
(204, 'Miguel', 'Pérez', 'Calle 10 #22-34', 'Medicina', 23),
(205, 'Sofía', 'Gómez', 'Pasaje Azul 789', 'Historia', 20);

-- INSERTAR DATOS TABLA PRESTAMO
INSERT INTO PRESTAMO (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(201, 101, '2024-04-01', '2024-04-10', 1),
(202, 102, '2024-04-03', NULL, 0),
(203, 103, '2024-04-05', '2024-04-12', 1),
(204, 104, '2024-04-10', NULL, 0),
(205, 105, '2024-04-11', NULL, 0),
(201, 102, '2024-04-15', NULL, 0);

/* 1. Listar los datos de los autores. */
SELECT a.id_autor, a.nombre, a.nacionalidad FROM AUTOR AS A;

/* 2. Listar nombre y edad de los estudiantes */
SELECT e.nombre, e.edad FROM ESTUDIANTE AS E;

/* 3. ¿Qué estudiantes pertenecen a la carrera informática? */
SELECT e.id_lector, e.nombre, e.apellido, e.direccion, e.carrera, e.edad FROM ESTUDIANTE AS E
WHERE LOWER(e.carrera) LIKE '%informática%';

/* 4. ¿Qué autores son de nacionalidad francesa o italiana? */
SELECT a.nombre FROM AUTOR AS A 
WHERE a.nacionalidad IN ('francesa', 'italiana');

/* 5. ¿Qué libros no son del área de internet? */
SELECT l.id_libro, l.titulo, l.editorial, l.area FROM LIBRO AS L
WHERE L.area != 'internet';

/* 6. Listar los libros de la editorial Salamandra. */
SELECT l.id_libro, l.titulo, l.editorial, l.area FROM LIBRO AS L
WHERE l.editorial IN ('Salamandra');

/* 7. Listar los datos de los estudiantes cuya edad es mayor al promedio. */
SELECT e.id_lector, e.nombre, e.apellido, e.direccion, e.carrera, e.edad FROM ESTUDIANTE AS E
WHERE e.edad > (SELECT AVG(EDAD) FROM ESTUDIANTE);

/* 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G. */
SELECT e.nombre FROM ESTUDIANTE AS E
WHERE e.apellido LIKE 'G%';

/* 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres). */
SELECT A.nombre
FROM AUTOR A
JOIN LIBRO_AUTOR LA ON A.id_autor = LA.id_autor
JOIN LIBRO L ON LA.id_libro = L.id_libro
WHERE L.titulo = 'El Universo: Guía de viaje';

/* 10. ¿Qué libros se prestaron al lector “Filippo Galli”? */
SELECT * FROM PRESTAMO AS P
JOIN ESTUDIANTE AS E ON P.id_lector = E.id_lector
JOIN LIBRO AS L ON P.id_libro = L.id_libro
WHERE E.nombre = 'Filippo' AND E.apellido = 'Galli';

/* 11. Listar el nombre del estudiante de menor edad. */
SELECT e.nombre FROM ESTUDIANTE AS E 
WHERE e.edad IN (SELECT MIN(E.EDAD) FROM ESTUDIANTE AS E);

/* 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. */
SELECT E.nombre FROM ESTUDIANTE AS E
JOIN PRESTAMO AS P ON P.id_lector = E.id_lector
JOIN LIBRO AS L ON P.id_libro = L.id_libro
WHERE L.titulo LIKE '%Base de Datos%';

/* 13. Listar los libros que pertenecen a la autora J.K. Rowling. */
SELECT L.id_libro, L.titulo, L.editorial, L.area FROM LIBRO AS L
JOIN LIBRO_AUTOR AS LA ON LA.id_libro = L.id_libro
JOIN AUTOR AS A ON LA.id_autor = A.id_autor
WHERE A.nombre = 'J.K. Rowling';

/* 14. Listar títulos de los libros que debían devolverse el 16/07/2021. */
SELECT L.titulo FROM LIBRO AS L
JOIN PRESTAMO AS P ON P.id_libro = L.id_libro
WHERE P.fecha_devolucion = '2021-07-16';






