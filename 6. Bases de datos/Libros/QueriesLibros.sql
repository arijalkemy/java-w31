/*Listar los datos de los autores.*/
SELECT * from autor;

/*Listar nombre y edad de los estudiantes*/
SELECT nombre, edad FROM estudiante;

/*¿Qué estudiantes pertenecen a la carrera informática?*/
SELECT * FROM estudiante WHERE carrera ="informática";

/*¿Qué autores son de nacionalidad francesa o italiana?*/
SELECT * FROM autor WHERE Nacionalidad = "Italia" OR Nacionalidad = "Francia";

/*¿Qué libros no son del área de internet?*/
SELECT * FROM libro WHERE area = "físico";

/*Listar los libros de la editorial Salamandra.*/
SELECT * FROM libro WHERE editorial = "Salamandra";

/*Listar los datos de los estudiantes cuya edad es mayor al promedio.*/
SELECT * FROM Estudiante
WHERE Edad > (SELECT AVG(Edad) FROM Estudiante);

/*Listar los nombres de los estudiantes cuyo apellido comience con la letra G.*/
SELECT nombre, apellido FROM estudiante WHERE apellido LIKE "G%";

/*Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).*/
SELECT a.Nombre FROM Autor a
JOIN LibroAutor la ON a.idAutor = la.idAutor
JOIN Libro l ON la.idLibro = l.idLibro
WHERE l.Titulo = 'El Universo: Guía de viaje';

/*¿Qué libros se prestaron al lector “Filippo Galli”?*/
SELECT l.titulo FROM libro l
JOIN prestamo p ON l.idLibro = p.idLibro
JOIN estudiante e on p.idLector = e.idLector
WHERE nombre = "Filippo" AND apellido = "Galli";

/*Listar el nombre del estudiante de menor edad.*/
SELECT nombre FROM estudiante
Order By edad Limit 3;

/*Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.*/
SELECT e.nombre, e.apellido
FROM estudiante e
JOIN prestamo p ON e.idLector = p.idLector
JOIN libro l ON p.idLibro = l.idLibro
WHERE l.titulo LIKE '%Base de Datos%';

/*Listar los libros que pertenecen a la autora J.K. Rowling.*/
SELECT l.titulo
FROM libro l
JOIN libroautor la ON l.idLibro = la.idLibro
JOIN autor a ON la.idAutor = a.idAutor
WHERE a.nombre = 'J.K. Rowling';


/*Listar títulos de los libros que debían devolverse el 16/07/2021.*/
SELECT l.titulo
FROM libro l
JOIN prestamo p ON l.idLibro = p.idLibro
WHERE p.FechaDevolucion = '2021-07-16';
