-- Creación de tabla temporal para los episodios de The Walking Dead

CREATE TEMPORARY TABLE TWD (
	episode_title VARCHAR(255),
	season_number INT
);

INSERT INTO TWD (
	SELECT e.title, s.number 
	FROM episodes e 
	INNER JOIN seasons s ON e.season_id = s.id
	INNER JOIN series ON s.serie_id = series.id
	WHERE series.title = 'The Walking Dead'
)

SELECT * FROM TWD
WHERE season_number = 1;

-- Creación de un índice en la columna 'awards' en la tabla 'movies'
-- Se hicieron muchas consultas filtrando por cantidad de awards, por lo que creemos que sería útil obtener
-- dichas películas más eficientemente

ALTER TABLE movies 
ADD INDEX awards_idx (awards);

SHOW INDEX FROM movies;

SELECT * FROM movies
WHERE awards > 3;

EXPLAIN SELECT * FROM movies
WHERE awards > 3;
