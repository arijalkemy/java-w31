USE movies_db;

-- Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ("Los juegos del hambre: balada de pájaros cantores y serpientes",
7, 0, "2023-05-13", 120, 5);

SELECT * FROM movies;

-- Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking, active)
VALUES ("Distopia", 13, 1);

SELECT * FROM genres;

-- Asociar a la película del punto 1 con el el género creado en el punto 2.
UPDATE movies SET genre_id=13 WHERE id=22;

SELECT * FROM movies;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id=22 WHERE id=1;

SELECT * FROM actors;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temporal
SELECT * FROM movies;

SELECT * FROM movies_temporal;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temporal WHERE awards<5;

SELECT * FROM movies_temporal;

SELECT * FROM movies;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * FROM genres 
WHERE id IN (
	SELECT DISTINCT genre_id FROM movies
);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * FROM actors
WHERE favorite_movie_id IN (
	SELECT id FROM movies WHERE awards > 3
);

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_title_movies ON movies(title);
DROP INDEX idx_title_movies ON movies;

-- Chequee que el índice fue creado correctamente.
SHOW INDEXES FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
EXPLAIN SELECT * FROM movies where title="Toy Story 2";
-- Al ejecutar la anterior consulta sin y con el indice se muestra que existe una mejora notable, ya que se accede directamente al registro
-- con el valor solicitado sin tener que revisar todos

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En la tabla series en la columna genre_id para facilitar la búsqueda de series de un genero en especifico