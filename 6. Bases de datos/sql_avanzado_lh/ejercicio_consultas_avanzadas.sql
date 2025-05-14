#1
SELECT
	s.title,
	g.name
FROM
	movies_db.series s
INNER JOIN movies_db.genres g ON
	g.id = s.genre_id;

#2
SELECT
	title,
	first_name,
	last_name
FROM
	movies_db.actor_episode ae
INNER JOIN movies_db.actors a ON
	ae.actor_id = a.id
INNER JOIN movies_db.episodes e ON
	ae.episode_id = e.id;

#3 Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT
	title,
	episodes
FROM
	movies_db.series s
INNER JOIN 
		(
	SELECT
		sea.serie_id,
		COUNT(*) as episodes
	FROM
		movies_db.seasons sea
	GROUP BY
		sea.serie_id) as sea
		ON
	s.id = sea.serie_id;

#4 Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT
	name,
	movies_amount
FROM
	movies_db.genres g
INNER JOIN 
		(
	SELECT
		genre_id,
		COUNT(*) as movies_amount
	FROM
		movies_db.movies m
	GROUP BY
		m.genre_id) as m
		ON
	g.id = m.genre_id
WHERE
	movies_amount >= 3;

#5 Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT
	first_name, last_name
FROM
	movies_db.actor_movie am
INNER JOIN movies_db.actors a ON
	a.id = am.actor_id
INNER JOIN movies_db.movies m ON
	m.id = am.id
WHERE
	title LIKE "%La Guerra de las galaxias%"