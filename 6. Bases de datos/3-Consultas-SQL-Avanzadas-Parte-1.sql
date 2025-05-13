# Mostrar el título y el nombre del género de todas las series.
SELECT mv.title as "Título de película", g.name as "Nombre de género"
FROM movies mv
LEFT JOIN genres g on mv.genre_id = g.id;

# Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name
FROM episodes as e
INNER JOIN actor_episode ae on ae.episode_id = e.id
INNER JOIN actors a on a.id = ae.actor_id;

# Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, count(*)
FROM series s
INNER JOIN seasons se on s.id = se.serie_id
GROUP BY s.title;

# Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, count(*) as total
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.id
HAVING total > 3;

# Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT Nombre, Apellido
FROM(
	SELECT a.first_name as "Nombre", a.last_name as "Apellido"
	FROM movies m
	INNER JOIN actor_movie am on m.id = am.movie_id
	INNER JOIN actors a ON a.id = am.actor_id
	WHERE title LIKE "%La Guerra de las galaxias%"
) as movies_actors;

