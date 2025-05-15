USE biblioteca;

-- 1. Listar los datos de los autores.
SELECT *
FROM autor;

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM estudiante
WHERE carrera LIKE 'Infórmatica';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad
FROM autor
WHERE nacionalidad LIKE 'francesa' OR nacionalidad LIKE 'italiana';

-- 5. ¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE area NOT LIKE 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE editorial LIKE 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT au.nombre
FROM autor au 
JOIN libro_autor la ON au.id_autor = la.id_autor 
JOIN libro li ON la.id_libro = li.id_libro
WHERE li.titulo LIKE 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT li.titulo
FROM libro li 
JOIN prestamo pr ON li.id_libro = pr.id_libro
JOIN estudiante es ON pr.id_lector = es.id_lector
WHERE es.nombre LIKE 'Filippo' AND es.apellido LIKE 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido
FROM estudiante
ORDER BY edad
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT es.nombre, es.apellido
FROM libro li 
JOIN prestamo pr ON li.id_libro = pr.id_libro
JOIN estudiante es ON pr.id_lector = es.id_lector
WHERE li.area LIKE 'Base de Datos';


-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT li.titulo, li.editorial, li.area
FROM autor au 
JOIN libro_autor la ON au.id_autor = la.id_autor 
JOIN libro li ON la.id_libro = li.id_libro
WHERE au.nombre LIKE 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT li.titulo, pr.fecha_devolucion
FROM libro li 
JOIN prestamo pr ON li.id_libro = pr.id_libro
WHERE pr.fecha_devolucion = '2021-07-16'
