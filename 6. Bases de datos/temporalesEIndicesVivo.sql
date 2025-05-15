DROP TEMPORARY TABLE TWD;

CREATE TEMPORARY TABLE TWD AS
SELECT 
	e.title name_episode,
	sea.title season_name,
	se.title series_name 
FROM EPISODES e
JOIN SEASONS sea ON e.season_id = sea.id
JOIN SERIES se ON sea.serie_id = se.id
WHERE se.title LIKE 'The Walking Dead';

SELECT *
FROM TWD
WHERE season_name LIKE 'primer temporada'

CREATE INDEX idx_tittle ON movies(title);
SHOW INDEX FROM movies

INSERT INTO MOVIES(title, rating, awards, release_date, length)
VALUES('Titanes del Pacifico', 10.1, 1, '2013-07-11 14:30:00', 220);

INSERT INTO GENRES(name, ranking, active)
VALUES('Peliculon', 13, 1)

UPDATE MOVIES SET genre_id = (SELECT id FROM genres WHERE name = 'Peliculon') WHERE title LIKE 'Titanes del Pacifico';

UPDATE ACTORS SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'Titanes del Pacifico') WHERE id = 7;

CREATE TEMPORARY TABLE temp_movies AS
SELECT * FROM movies;

SELECT * FROM temp_movies;

DELETE FROM temp_movies
WHERE awards < 5;

SELECT DISTINCT g.name
FROM genres g
JOIN movie_genre mg ON g.id = mg.genre_id
JOIN movies m ON mg.movie_id = m.id;

SELECT a.*
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

CREATE INDEX idx_movie_title ON movies(title);

SHOW INDEX FROM movies;

