-- Mostrar el título y el nombre del género de todas las series.

SELECT s.title, g.name
FROM series s INNER JOIN genres g ON
s.genre_id = g.id

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT e.title, a.first_name, a.last_name
FROM actor_episode ae INNER JOIN actors a ON 
ae.actor_id = a.id INNER JOIN episodes e ON
ae.episode_id = e.id

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT series.title, COUNT(seasons.id) AS total_seasons
FROM seasons INNER JOIN series ON serie_id = series.id
GROUP BY series.id

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, 
-- siempre que sea mayor o igual a 3.

SELECT genres.name, COUNT(movies.id) AS total_movies
FROM movies INNER JOIN genres ON genre_id = genres.id
GROUP BY genres.id
HAVING total_movies >= 3

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las 
-- galaxias y que estos no se repitan.

SELECT DISTINCT a.first_name, a.last_name
FROM actors a
INNER JOIN actor_movie am ON am.actor_id = a.id
INNER JOIN movies m ON m.id = am.movie_id
WHERE m.title LIKE '%Guerra de las galaxias%' -- me quedo solo con los registros con peliculas de star wars
GROUP BY a.id						          -- agrupo los registros por cada actor
HAVING COUNT(m.id) = (                        -- se cuentan en cuantas de esas peliculas estuvo el actor
	SELECT COUNT(*)                           -- y tiene que ser igual a la cantidad de peliculas de star wars que hay
	FROM movies
	WHERE title LIKE '%Guerra de las galaxias%'
)
