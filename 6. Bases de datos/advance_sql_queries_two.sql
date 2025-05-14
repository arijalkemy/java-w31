use movies_db;
-- Agregar una película a la tabla movies.
SELECT * FROM movies;
INSERT INTO movies(CREATED_AT,UPDATED_AT,TITLE,RATING,AWARDS,RELEASE_DATE,LENGTH,GENRE_ID)
VALUES(NULL,NULL,"El eternauta",9.9,123,"2025-05-04",180,1);

-- Agregar un género a la tabla genres.
SELECT * FROM genres;
INSERT INTO genres(CREATED_AT,UPDATED_AT,NAME,RANKING,ACTIVE)
VALUES("2016-07-04",NULL,"Romance",13,1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET GENRE_ID = 13 WHERE ID = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SELECT * FROM actors;
UPDATE actors SET FAVORITE_MOVIE_ID = 22 WHERE ID = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copy_movies(SELECT * FROM movies);
SELECT * FROM copy_movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM copy_movies WHERE AWARDS < 5;
SET SQL_SAFE_UPDATES = 1;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.* FROM genres g
INNER JOIN movies m ON g.ID = m.GENRE_ID
WHERE m.GENRE_ID IS NOT NULL;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.* FROM actors a
INNER JOIN movies m ON a.FAVORITE_MOVIE_ID = m.ID
WHERE m.AWARDS > 3;

-- Crear un índice sobre el nombre en la tabla movies.
SELECT * FROM movies;
CREATE INDEX idx_title ON movies(TITLE);

-- Chequee que el índice fue creado correctamente.
EXPLAIN SELECT * FROM movies WHERE TITLE = "Parque Jurasico";
-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/* Dependera del caso de uso de la BD, si la base de datos se utiliza para buscar estrenos de peliculas, el mejor indice estaria en las fechas por ejemplo. */
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*Otro indice que agregaria seria en la misma tabla en los nombre de las peliculas cuando se busca una pelicula en especial teniendo en cuenta que nuestra api solo se encargue de mostrar estrenos, buscar el estreno por nombre. */