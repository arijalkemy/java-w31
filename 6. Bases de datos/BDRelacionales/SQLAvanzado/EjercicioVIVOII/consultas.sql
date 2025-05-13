-- Listar los datos de los autores.
SELECT * FROM autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, apellido, edad
FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido, carrera
FROM estudiante
WHERE carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad
FROM autor
WHERE nacionalidad IN ('Frances', 'Italiano');

-- ¿Qué libros no son del área de internet?
SELECT titulo, editorial, area
FROM libro
WHERE area <> 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT titulo, editorial, area
FROM libro
WHERE editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, apellido, direccion, carrera, edad
FROM estudiante e
WHERE e.edad > (
	SELECT AVG(e2.edad)
    FROM estudiante e2
);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
INNER JOIN libroAutor i ON a.idAutor = i.idAutor
INNER JOIN libro l ON l.idLibro = i.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo, l.editorial, l.area
FROM libro l
INNER JOIN prestamo p ON l.idLibro = p.idLibro
INNER JOIN estudiante e ON p.idLector = e.idLector
WHERE e.nombre = 'Filippo'
  AND e.apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido, edad
FROM estudiante
WHERE edad = (SELECT MIN(edad) FROM estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT e.nombre, e.apellido
FROM estudiante e
INNER JOIN prestamo p ON e.idLector = p.idLector
INNER JOIN libro l ON p.idLibro = l.idLibro
WHERE l.area = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo, l.editorial, l.area
FROM libro l
INNER JOIN libroAutor la ON l.idLibro = la.idLibro
INNER JOIN autor a ON la.idAutor = a.idAutor
WHERE a.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libro l
INNER JOIN prestamo p ON l.idLibro = p.idLibro
WHERE p.fechaDevolucion = '2021-07-16';