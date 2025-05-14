-- Agregar una película a la tabla movies.

INSERT INTO movies(title, rating, awards, release_date, `length`, genre_id) VALUES
('Clueless', 6.9, 3, '1995-12-07', 97, 1);

-- Agregar un género a la tabla genres.

INSERT INTO genres(name, ranking) VALUES
('Comedia romántica', 13);


-- Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE movies SET genre_id = 14 WHERE title = 'Clueless';


-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE actors SET favorite_movie_id = 22 WHERE id = 14;


-- Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE movies_copy
	SELECT * FROM movies;

SELECT * FROM movies_copy;


-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE FROM movies_copy WHERE awards < 5;

SELECT * FROM movies_copy;


-- Obtener la lista de todos los géneros que tengan al menos una película.

SELECT DISTINCT g.name
FROM genres g 
INNER JOIN movies m ON g.id = m.genre_id;


-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT a.first_name, a.last_name
FROM actors a 
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;


-- Crear un índice sobre el nombre en la tabla movies.

ALTER TABLE movies
ADD INDEX title_idx (title);


-- Chequee que el índice fue creado correctamente.

SHOW INDEX FROM movies;


-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.


-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta