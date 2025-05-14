use movies_db;
/*Agregar una película a la tabla movies.*/
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id) values
('20250514', '20250514', 'Un viernes de locos', 8.0, 1, '20030518',97, 1);
/*Agregar un género a la tabla genres.*/
INSERT INTO genres (created_at, updated_at, name, ranking, active) VALUES
('20250513', '20250514', 'Romántica', 13, 1); 
SELECT * FROM GENRES;
/*Asociar a la película del punto 1. genre el género creado en el punto 2.*/
UPDATE movies SET genre_id = 14 WHERE id = 22;
/*Modificar la tabla actors para que al menos un actor tenga como favorita 
la película agregada en el punto 1.*/
UPDATE actors SET favorite_movie_id = 22 WHERE id = 3;
/*Crear una tabla temporal copia de la tabla movies.*/
CREATE TEMPORARY TABLE movies_temporary (
  id int(10) unsigned NOT NULL,
  created_at timestamp NULL DEFAULT NULL,
  updated_at timestamp NULL DEFAULT NULL,
  title varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  rating decimal(3,1) unsigned NOT NULL,
  awards int(10) unsigned NOT NULL DEFAULT 0,
  release_date datetime NOT NULL,
  length int(10) unsigned DEFAULT NULL,
  genre_id int(10) unsigned DEFAULT NULL
);

/*Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.*/
INSERT INTO movies_temporary
SELECT * FROM movies;
DELETE FROM movies_temporary
WHERE awards < 5;
/*Obtener la lista de todos los géneros que tengan al menos una película.*/
SELECT g.name
FROM genres g
WHERE EXISTS (SELECT 1 FROM movies m WHERE m.genre_id = g.id);

/*Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.*/
SELECT a.first_name
FROM actors a
WHERE favorite_movie_id IN (SELECT id FROM movies WHERE awards > 3);

/*Crear un índice sobre el nombre en la tabla movies.*/
CREATE INDEX title_movie_idx ON movies (title);
/*Chequee que el índice fue creado correctamente.*/
EXPLAIN SELECT * FROM movies WHERE title = 'Un viernes de locos';

/*En la base de datos movies ¿Existiría una mejora notable al crear índices? 
Analizar y justificar la respuesta.*/
/* En el caso de las tablas actor_episode, actor_movie, y actors en la base de datos 
movies_db, los índices ya están creados para las columnas actor_id y episode_id
 (en la tabla actor_episode), así como para movie_id en la tabla actor_movie y 
 favorite_movie_id en la tabla actors. Sin embargo, se pueden considerar mejoras
 adicionales para optimizar el rendimiento de consultas complejas, 
 especialmente aquellas que involucran búsquedas, uniones y filtros.*/
 
/*¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta*/
/* Si se realizan consultas con frecuencia que filtran por el campo rating
 (por ejemplo, para buscar actores con un rating superior a un valor específico),
 crear un índice en esa columna podría mejorar el rendimiento de dichas consulta*/