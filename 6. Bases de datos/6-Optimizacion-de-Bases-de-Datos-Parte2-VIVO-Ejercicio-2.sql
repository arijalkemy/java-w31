use movies_db;

# Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ("Interestelar", 9, 11, "26-10-26 00:00:00", 169, 5);

# Agregar un género a la tabla genres.
INSERT INTO genres(created_at, name, ranking, active)
VALUES (NOW(), "Romántico", 13, 1);

# Asociar a la película del punto 1. genre el género creado en el punto 2
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name = "Romántico")
WHERE id = 22;

# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = "Interestelar")
WHERE id = 4;

# Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_tmp (
	SELECT * FROM movies
);

SET SQL_SAFE_UPDATES = 0;

# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_tmp WHERE awards > 5;

# Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.*, count(*) AS total_movies
FROM genres g
LEFT JOIN movies m ON g.id = m.genre_id
GROUP BY g.id
HAVING total_movies > 1;

# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name
FROM actors a
INNER JOIN movies m ON  a.favorite_movie_id = m.id
WHERE m.awards > 3;

# Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_title
ON movies (title);
DROP INDEX index_title ON movies;

# Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
EXPLAIN select * from movies where title like "A%"; 
/*
	Esta consulta mejora en rows analizadas con índices en title, de examinar 21 filas, examina solo dos.
    Sin el índice tenemos que se examinan 22 rows y el 11.11% son filtradas. Estos valores nos dan la idea de que con un indice se puede obtener un cambio positivo.
*/

# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
	En actors en las columnas firs_name y last_name si existen muchas consultan donde se filtre por estas columnas.
*/

