-- En base al mismo, plantear las consultas SQL para resolver los siguientes requerimientos:

-- Listar los datos de los autores.
SELECT * FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM ESTUDIANTE;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM ESTUDIANTE
WHERE Carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM AUTOR
WHERE Nacionalidad IN ('Francesa', 'Italiana');

-- ¿Qué libros no son del área de internet?
SELECT * FROM LIBRO
WHERE Area <> 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT * FROM LIBRO
WHERE Editorial = 'Salamandra';


-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM ESTUDIANTE
WHERE Edad > (
    SELECT AVG(Edad) FROM ESTUDIANTE
);


-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre FROM ESTUDIANTE
WHERE Apellido LIKE 'G%';


-- Listar los autores del libro 'El Universo: Guía de viaje'. (Se debe listar solamente los nombres).
SELECT A.Nombre
FROM AUTOR A
JOIN LIBROAUTOR LA ON A.idAutor = LA.idAutor
JOIN LIBRO L ON LA.idLibro = L.idLibro
WHERE L.Titulo = 'El Universo: Guía de viaje';


-- ¿Qué libros se prestaron al lector 'Filippo Galli'?
SELECT L.Titulo
FROM LIBRO L
JOIN PRESTAMO P ON L.idLibro = P.idLibro
JOIN ESTUDIANTE E ON P.idLector = E.idLector
WHERE E.Nombre = 'Filippo' AND E.Apellido = 'Galli';


-- Listar el nombre del estudiante de menor edad.
SELECT Nombre
FROM ESTUDIANTE
WHERE Edad = (
    SELECT MIN(Edad) FROM ESTUDIANTE
);


-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT E.Nombre
FROM ESTUDIANTE E
JOIN PRESTAMO P ON E.idLector = P.idLector
JOIN LIBRO L ON P.idLibro = L.idLibro
WHERE L.Area = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT L.Titulo
FROM LIBRO L
JOIN LIBROAUTOR LA ON L.idLibro = LA.idLibro
JOIN AUTOR A ON LA.idAutor = A.idAutor
WHERE A.Nombre = 'J.K. Rowling';


-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT L.Titulo
FROM LIBRO L
JOIN PRESTAMO P ON L.idLibro = P.idLibro
WHERE P.FechaDevolucion = '2021-07-16';

-- Ejercicio 2
-- Implementar la base de datos en PHPMyAdmin o MySQL Workbench, 
-- cargar cinco registros en cada tabla y probar algunas consultas planteadas en el Ejercicio 1.



