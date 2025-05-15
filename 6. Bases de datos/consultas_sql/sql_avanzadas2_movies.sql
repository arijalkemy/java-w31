-- Agregar una película a la tabla movies.
INSERT INTO movies (title,rating,awards,release_date,length,genre_id)
VALUES ('Nueva pelicula', 8.5, 10, '2025-05-14', 120, 1);

-- Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking, active)
VALUES ('Sci-Fi',13,1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name = 'Sci-Fi')
WHERE title = 'Nueva pelicula';

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'Nueva pelicula')
WHERE id = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies AS
SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM temp_movies 
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name 
FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY g.name;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name 
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_movies_title 
ON movies (title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta
/*. Si, ya que puede contener muchos registros debido a la naturaleza de la base de datos.
Consultas frecuentes como buscar peliculas por nombre o filtrar por número de premios, 
se benefician significativamente de un índice.
El indice en el campo title mejora las búsquedas de peliculas especificas y la organización de resultados.*/

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*En la tabla actors en el campo last_name, porque al listar actores, las busquedas generalmente se realizan por apellido
o por nombre. El indice permitirá acelerar las consultas que involucran busquedas por apellido.*/
