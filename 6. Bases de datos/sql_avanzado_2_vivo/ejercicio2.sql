-- 1 Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('Spiderman: Into the Spider-Verse', 8.4, 10, '2018-12-14 00:00:00', 117, NULL);
-- 2 Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking, active)
VALUES ('Animación 3D', 13, 1);
-- 3 Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE id = 22;
-- 4 Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 31;
-- 5 Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp AS SELECT * FROM movies;
-- 6 Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp WHERE awards < 5;
-- 7 Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.name
FROM genres g
JOIN movies m ON g.id = m.genre_id;
-- 8 Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;
-- 9 Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_movies_title ON movies (title);
-- 10 Chequee que el índice fue creado correctamente.
SHOW INDEXES FROM movies;
-- 11 En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Respuesta: En la base de datos que tenemos no vamos a ver una mejora notable porque es muy chica. Si fuera una base de datos mas grande tendriamos una mejora notoria para los casos en los que se busque por titulo de pelicula.
-- 12 ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Pensando en consultas comunes en bases de datos de películas/series, crearía un índice adicional en actors, en las columnas last_name, first_name.


SELECT * FROM movies_db.actors;
SELECT * FROM movies_db.movies;
SELECT * FROM movies_temp;