USE movies_db;

DROP TEMPORARY TABLE the_walking_dead;

-- Tabla temporal para los episodios de todas las temporadas de "The Walking Dead"
CREATE TEMPORARY TABLE the_walking_dead
SELECT e.id, e.title, e.number, e.release_date, e.rating, sea.title as season_title, ser.title as serie
FROM episodes e
INNER JOIN seasons sea ON e.season_id = sea.id
INNER JOIN series ser ON sea.serie_id = ser.id
WHERE ser.title LIKE "The Walking Dead";

SELECT * FROM the_walking_dead;

-- Consulta de los episodios de la primera temporada de "The Walking Dead"
SELECT * FROM the_walking_dead WHERE season_title LIKE "Primer Temporada";

-- Creacion de un indice
EXPLAIN SELECT * FROM movies WHERE genre_id = 5 AND rating >7.5;

CREATE INDEX idx_movies_genre_rating ON movies(genre_id, rating);

EXPLAIN SELECT * FROM movies WHERE genre_id = 5 AND rating >7.5;