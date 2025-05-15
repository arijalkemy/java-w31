USE movies_db;

-- 2. Agregar un género a la tabla genres.
INSERT INTO `genres` VALUES (13,'2016-07-04 03:00:00',NULL,'Distopía',13,1);

-- 1. Agregar una película a la tabla movies.
INSERT INTO `movies` VALUES (22,NULL,NULL,'Al filo del mañana',9.9,10,'2010-10-04 00:00:00',150,13);  

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 1;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy (
	`id` int(10) unsigned NOT NULL,
	`created_at` timestamp NULL DEFAULT NULL,
	`updated_at` timestamp NULL DEFAULT NULL,
	`title` varchar(500) NOT NULL,
	`rating` decimal(3,1) unsigned NOT NULL,
	`awards` int(10) unsigned NOT NULL DEFAULT '0',
	`release_date` datetime NOT NULL,
	`length` int(10) unsigned DEFAULT NULL,
	`genre_id` int(10) unsigned DEFAULT NULL
);

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT ge.* FROM genres ge JOIN movies mo ON ge.id = mo.genre_id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT ac.* FROM actors ac JOIN movies mo ON ac.favorite_movie_id = mo.id WHERE mo.awards > 3;

EXPLAIN SELECT * FROM movies WHERE title LIKE 'La Guerra %';

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_title_idx ON movies (title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
EXPLAIN SELECT * FROM movies WHERE title LIKE 'La Guerra %';

-- Haciendo el analisis con el Explain, me doy cuneta que antes de incluir el indice analizaba unicamente 1 fila
-- Pero despues de incluir el indice analiza 2 filas, los resultados difieren con los de mis compañeros despues de socializarlos
-- En mi propia experiencia con este ejercicio no existe una mejora notable

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En series, ya que igualmente puede ser una consulta recurrente buscar por titulo una serie.