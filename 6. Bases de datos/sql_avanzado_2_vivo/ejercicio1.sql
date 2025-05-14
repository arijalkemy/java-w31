# Ejercicio 1
# 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

DROP TABLE IF EXISTS twd;
CREATE TEMPORARY TABLE twd 
	AS 
	(SELECT
    s.title AS series_title,     
    sea.title AS season_title,   
    sea.id AS season_id,        
    epi.title AS episode_title,   
    epi.number AS episode_number,        
    epi.id AS episode_id
FROM
    movies_db.series AS s
INNER JOIN
    movies_db.seasons AS sea ON s.id = sea.serie_id
INNER JOIN
    movies_db.episodes AS epi ON sea.id = epi.season_id
WHERE
    s.title = "The Walking Dead");

# 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM twd WHERE season_title LIKE "Primer Temporada";

# Ejercicio 2
# 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX idx_release_date ON movies_db.movies(release_date)

EXPLAIN SELECT * FROM movies_db.movies WHERE release_date BETWEEN "2005-01-01" AND "2019-12-31";