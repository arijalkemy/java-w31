-- Agregar una película a la tabla movies.
INSERT INTO movies ( created_at, updated_at, title, rating, awards, release_date, length, genre_id) 
VALUES (null, null, 'The Great Adventure', 8.2, 3, '2023-10-01', 120, 1);

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at, name, ranking, active) 
VALUES (CURRENT_TIMESTAMP, null, "Thriller", 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE title = 'The Great Adventure';

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'The Great Adventure') WHERE id = 1;

-- Crear una tabla temporal copia de la tabla movies.
DROP TEMPORARY TABLE movies_copy;
CREATE TEMPORARY TABLE movies_copy (
	id INT NOT NULL PRIMARY KEY,
    created_at DATETIME NULL,
    updated_at DATETIME NULL,
    title VARCHAR(100),
    rating DOUBLE,
    awards INT,
    release_date DATETIME NULL,
    lenght INT,
    genre_id INT
);

INSERT INTO movies_copy SELECT * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET sql_safe_updates = 0;
DELETE FROM movies_copy WHERE awards < 5;
SET sql_safe_updates = 1;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name AS Nombre FROM genres g 
INNER JOIN movies_copy mc ON g.id = mc.genre_id GROUP BY Nombre;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards
SELECT CONCAT(a.first_name, " ", a.last_name) AS Nombre_actor FROM actors a
INNER JOIN movies m ON m.id = a.favorite_movie_id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_movies ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
