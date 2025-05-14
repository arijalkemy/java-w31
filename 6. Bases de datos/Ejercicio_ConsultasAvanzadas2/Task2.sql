USE movies_db;
-- Consultas SQL Avanzadas 2

-- 1. Agregar una película a la tabla movies.
INSERT INTO movies VALUES (22,'2024-05-01','2025-05-10','Thunderbolts*',9.8, 0, '2025-05-01',160,5);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres VALUES (13,'2025-05-14 10:40:00',NULL,'Superhéroes',13,1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id=13 WHERE title LIKE 'Thunderbolts*' AND id = 22;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET  favorite_movie_id = 22 WHERE id = 32;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies AS
SELECT * FROM movies;
SELECT * FROM temp_movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards
DELETE FROM temp_movies WHERE awards < 5;
SELECT * FROM temp_movies;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.name
FROM movies m JOIN genres g ON m.genre_id = g.id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.*
FROM actors a JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9.Crear un índice sobre el nombre en la tabla movies.
SHOW INDEX FROM movies;
DROP INDEX idx_movies_title ON movies;

EXPLAIN SELECT * FROM movies WHERE title LIKE 'La Guerra%';

CREATE INDEX idx_movies_title ON movies(title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
EXPLAIN SELECT * FROM movies WHERE title LIKE 'La Guerra%';

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- Sí, existen mejoras notables al crear índices en la base de datos movies, especialmente si se busca optimizar el rendimiento de consultas frecuentes.
-- Los índices permiten  localizar datos rápidamente sin tener que escanear todas las filas de una tabla. Son especialmente útiles cuando:
-- Se hacen consultas con filtros (WHERE) sobre columnas específicas.
-- Se realizan uniones (JOIN) entre tablas usando claves foráneas.
-- Se hacen ordenamientos (ORDER BY) o búsquedas (LIKE).
-- Se busca evitar full table scans en tablas con muchos registros.

-- 12. ¿Dónde podría agregarse otro índice en movies?
-- title → para búsquedas por título (aunque para LIKE '%valor%' no será tan efectivo).
-- release_date → si se hacen muchos filtros o rangos por fecha de estreno.
-- La tabla episodes, específicamente sobre la columna release_date.alter
-- 