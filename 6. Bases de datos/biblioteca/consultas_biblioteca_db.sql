-- Listar los datos de los autores.

SELECT *
FROM autor

-- Listar nombre y edad de los estudiantes

SELECT nombre, edad
FROM estudiante

-- ¿Qué estudiantes pertenecen a la carrera informática?

SELECT *
FROM estudiante
WHERE carrera = 'Informatica'


-- ¿Qué autores son de nacionalidad francesa o italiana?

SELECT *
FROM autor
WHERE nacionalidad = 'francesa' OR nacionalidad = 'italiana'


-- ¿Qué libros no son del área de internet?

SELECT *
FROM libro
WHERE area != 'Internet'


-- Listar los libros de la editorial Salamandra.

SELECT *
FROM libro
WHERE editorial = 'Salamandra'


-- Listar los datos de los estudiantes cuya edad es mayor al promedio.

SELECT *
FROM estudiante
WHERE edad > (
	SELECT AVG(edad)
	FROM estudiante
)

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

SELECT nombre
FROM estudiante
WHERE apellido LIKE 'G%'


-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

SELECT a.nombre
FROM libro_autor la INNER JOIN autor a ON id_autor = a.id
INNER JOIN libro l ON id_libro = l.id
WHERE l.titulo = 'El Universo: Guía de viaje'


-- ¿Qué libros se prestaron al lector “Filippo Galli”?

SELECT l.*
FROM prestamo p INNER JOIN libro l ON id_libro = l.id
INNER JOIN estudiante e ON id_estudiante = e.id
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli'


-- Listar el nombre del estudiante de menor edad.

SELECT nombre
FROM estudiante
WHERE edad = (
	SELECT MIN(edad)
	FROM estudiante
)


-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

SELECT e.nombre
FROM prestamo p INNER JOIN estudiante e ON id_estudiante = e.id
INNER JOIN libro l ON id_libro = l.id
WHERE l.area = 'Base de Datos'


-- Listar los libros que pertenecen a la autora J.K. Rowling.

SELECT l.*
FROM libro_autor INNER JOIN libro l ON id_libro = l.id
INNER JOIN autor a ON id_autor = a.id
WHERE a.nombre = 'J.K. Rowling'


-- Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT l.titulo
FROM prestamo p INNER JOIN libro l ON id_libro = l.id
WHERE p.fecha_devolucion = '2021-07-16'