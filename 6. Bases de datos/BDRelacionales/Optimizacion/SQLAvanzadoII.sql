-- Seleccionar la base de datos
USE movies_db;

-- Agregar una película a la tabla movies.
INSERT INTO movies (id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (111, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Ejemplo de Película', 7.5, 2, '2023-01-15', 120, NULL);

-- Agregar un género a la tabla genres.
INSERT INTO genres (id, created_at, updated_at, name, ranking, active)
VALUES (200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Acción', 1, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 200
WHERE id = 111;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 111
LIMIT 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copia_movies(
	id INT UNSIGNED PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    title VARCHAR(500),
    rating DECIMAL(3,1) UNSIGNED,
    awards INT UNSIGNED,
    release_date DATETIME,
    length INT UNSIGNED,
    genre_id INT UNSIGNED,
    FOREIGN KEY (genre_id) REFERENCES genres(id)
);

INSERT INTO copia_movies (id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM copia_movies
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.name
FROM movies m
INNER JOIN genres g ON g.id = m.genre_id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_title_movies ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- RTA: Si en la tabla movies se realizan consultas frecuentes que filtran o ordenan por columnas específicas
-- (por ejemplo, title, release_date o rating), un índice en esas columnas puede mejorar significativamente el rendimiento.
-- Además, a medida que la base de datos crece, disponer de índices adecuados puede marcar una diferencia en el tiempo de
-- respuesta de las consultas.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

-- RTA: Podrían crearse índices en campos que se consultan con frecuencia, como nombres de actores, nombres de géneros,
-- títulos y números de temporadas. Al indexar estas columnas, se aceleran las búsquedas y los filtros, mejorando el
-- rendimiento de las consultas, especialmente en bases de datos con mucha información.
-- De todas formas, es importante no agregar índices innecesarios, ya que cada índice implica un costo adicional en
-- inserciones y actualizaciones.



