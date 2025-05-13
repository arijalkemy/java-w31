-- 1
SELECT *
FROM Autores;

-- 2
SELECT nombre, edad
FROM Estudiantes;

-- 3
SELECT *
FROM Estudiantes
WHERE carrera = 'informática';

-- 4
SELECT *
FROM Autores
WHERE nacionalidad IN ('francesa', 'italiana');

-- 5
SELECT *
FROM Libros
WHERE area != 'internet'; -- O WHERE area <> 'internet';

-- 6
SELECT *
FROM Libros
WHERE editorial = 'Salamandra';

-- 7
SELECT *
FROM Estudiantes
WHERE edad > (SELECT AVG(edad) FROM Estudiantes);

-- 8
SELECT nombre
FROM Estudiantes
WHERE apellido LIKE 'G%';

-- 9
SELECT A.nombre
FROM Autores AS A
JOIN Libro_Autor AS LA ON A.id_autor = LA.id_autor
JOIN Libros AS L ON LA.id_libro = L.id_libro
WHERE L.titulo = 'El Universo: Guía de viaje';

-- 10
SELECT L.*
FROM Libros AS L
JOIN Prestamos AS P ON L.id_libro = P.id_libro
JOIN Estudiantes AS E ON P.id_estudiante = E.id_estudiante
WHERE E.nombre = 'Filippo' AND E.apellido = 'Galli';

-- 11
SELECT nombre
FROM Estudiantes
ORDER BY edad ASC
LIMIT 1;

-- 12
SELECT DISTINCT E.nombre
FROM Estudiantes AS E
JOIN Prestamos AS P ON E.id_estudiante = P.id_estudiante
JOIN Libros AS L ON P.id_libro = L.id_libro
WHERE L.area = 'Base de Datos';

-- 13
SELECT L.*
FROM Libros AS L
JOIN Libro_Autor AS LA ON L.id_libro = LA.id_libro
JOIN Autores AS A ON LA.id_autor = A.id_autor
WHERE A.nombre = 'J.K. Rowling';

-- 14
SELECT L.titulo
FROM Libros AS L
JOIN Prestamos AS P ON L.id_libro = P.id_libro
WHERE P.fecha_devolucion = '2021-07-16';