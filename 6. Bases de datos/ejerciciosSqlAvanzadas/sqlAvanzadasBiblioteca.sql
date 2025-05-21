INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(1, 'Gabriel García Márquez', 'Colombiana'),
(2, 'Isabel Allende', 'Chilena'),
(3, 'Julio Cortázar', 'Argentina'),
(4, 'Mario Vargas Llosa', 'Peruana'),
(5, 'Jorge Luis Borges', 'Argentina');

INSERT INTO LIBRO (idLibro, Título, Editorial, Area) VALUES
(1, 'Cien Años de Soledad', 'Sudamericana', 'Ficción'),
(2, 'La Casa de los Espíritus', 'Plaza & Janés', 'Ficción'),
(3, 'Rayuela', 'Sudamericana', 'Ficción'),
(4, 'La Ciudad y los Perros', 'Seix Barral', 'Ficción'),
(5, 'Ficciones', 'Emecé', 'Ficción');

INSERT INTO libro_autor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO estudiante (idLector, Nombre, Apellido, Dirección, Carrera, Edad) VALUES
(1, 'Juan', 'Pérez', 'Calle Falsa 123', 'Literatura', 21),
(2, 'Ana', 'Gómez', 'Avenida Siempre Viva 742', 'Historia', 22),
(3, 'Carlos', 'López', 'Calle Luna 33', 'Filosofía', 23),
(4, 'María', 'Díaz', 'Paseo del Prado 5', 'Arte', 24),
(5, 'Luis', 'Fernández', 'Gran Vía 1', 'Sociología', 20);

INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-01-10', '2023-01-20', TRUE),
(2, 2, '2023-01-15', '2023-01-25', FALSE),
(3, 3, '2023-01-20', '2023-01-30', TRUE),
(4, 4, '2023-01-25', '2023-02-04', FALSE),
(5, 5, '2023-01-30', '2023-02-09', TRUE);


/*1.*/
select * from autor;

/*2.*/
select nombre, edad from estudiante;

/*3.*/
update estudiante set carrera = "Informatica" where idLector = 1;
select estudiante.nombre, estudiante.apellido
from estudiante
where carrera = "Informatica";

/*4.*/
select nombre
from autor
where nacionalidad = "Francesa" or nacionalidad = "Italiana";

/*5.*/
select título
from libro
where area = "internet";

/*6.*/
update libro set editorial = "Salamandra" where idLibro = 1;
select idLibro, título
from libro
where Editorial = "Salamandra";

/*7.*/
select * from estudiante
where edad > (select avg(edad) from estudiante);

/*8.*/
select nombre
from estudiante
where apellido like 'G%';

/*9.*/
INSERT INTO LIBRO (idLibro, Título, Editorial, Area) VALUES
(6, 'El Universo: Guía de viaje', 'AstroEdit', 'Ciencia');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(6, 'Carl Sagan', 'Estadounidense'),
(7, 'Neil deGrasse Tyson', 'Estadounidense');
INSERT INTO LIBRO_AUTOR (idAutor, idLibro) VALUES
(6, 6), 
(7, 6); 

select autor.nombre
from autor inner join libro_autor on autor.idAutor = libro_autor.idAutor
inner join libro on libro.idLibro = libro_autor.idLibro
where libro.título = "El Universo: Guía de viaje";

/*10.*/
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Dirección, Carrera, Edad) VALUES
(6, 'Filippo', 'Galli', 'Via Roma 10', 'Astronomía', 25);
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(6, 1, '2023-02-01', '2023-02-15', TRUE), 
(6, 6, '2023-02-20', NULL, FALSE);

select libro.título
from libro inner join prestamo on libro.idLibro = prestamo.idLibro
inner join estudiante on estudiante.idLector = prestamo.idLector
where estudiante.nombre = "Filippo" and estudiante.apellido = "Galli";

/*11.*/
select nombre
from estudiante
where edad = (select min(edad) from estudiante);

/*12.*/
INSERT INTO LIBRO (idLibro, Título, Editorial, Area) VALUES
(7, 'Bases de Datos', 'DataPress', 'Ciencia de la Computación');

INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(6, 7, '2023-03-01', NULL, FALSE),             
(3, 7, '2023-03-02', '2023-03-12', TRUE);   

select estudiante.nombre, estudiante.apellido
from estudiante inner join prestamo on estudiante.idLector = prestamo.idLector
inner join libro on libro.idLibro = prestamo.idLibro
where libro.título = "Bases de Datos";

/*13.*/
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(8, 'J.K. Rowling', 'Británica');
INSERT INTO LIBRO (idLibro, Título, Editorial, Area) VALUES
(8, 'Harry Potter y la Piedra Filosofal', 'Bloomsbury', 'Fantasía'),
(9, 'Harry Potter y la Cámara Secreta', 'Bloomsbury', 'Fantasía');
INSERT INTO LIBRO_AUTOR (idAutor, idLibro) VALUES
(8, 8),  
(8, 9); 

select libro.título
from libro inner join libro_autor on libro.idLibro = libro_autor.idLibro
inner join autor on autor.idAutor = libro_autor.idAutor
where autor.nombre = "J.K. Rowling";

/*14.*/
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 2, '2021-07-01', '2021-07-16', FALSE),      
(2, 3, '2021-07-05', '2021-07-16', FALSE);  

select libro.título
from libro inner join prestamo on libro.idLibro = prestamo.idLibro
where prestamo.FechaDevolucion = '2021-07-16';   


