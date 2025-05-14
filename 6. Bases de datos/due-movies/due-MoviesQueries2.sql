-- Mostrar todos los registros de la tabla de movies.
SELECT * FROM movies;

-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating 
FROM actors;

-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title titulo 
FROM series series;

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name 
FROM actors 
WHERE rating > 7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards
FROM movies
Where rating > 7.5 AND awards > 2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating
FROM movies
ORDER BY rating;

-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title
FROM movies
LIMIT 3;

-- Mostrar el top 5 de las películas con mayor rating.
SELECT *
FROM movies
ORDER BY rating DESC
LIMIT 5;

-- Listar los primeros 10 actores.
SELECT *
FROM actors
LIMIT 10;

-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating
FROM movies
WHERE title = 'Toy Story';

-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT *
FROM actors
WHERE first_name LIKE 'Sam%';

-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title
FROM movies
WHERE release_date BETWEEN '2004-01-01' AND '2008-01-01';

-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title, release_date, awards, rating
FROM movies
WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1988-01-01' AND '2009-01-01'
ORDER BY rating;

-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s
INNER JOIN genres g ON g.id = s.genre_id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name
FROM episodes e
INNER JOIN actor_episode ae ON e.id = ae.episode_id
INNER JOIN actors a ON a.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(ss.id) seasons
FROM series s
INNER JOIN seasons ss ON s.id = ss.serie_id
GROUP BY s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(m.id) total_movies
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING total_movies >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name, m.title
FROM actors a
INNER JOIN actor_movie am ON a.id = am.actor_id
INNER JOIN movies m ON m.id = am.movie_id
WHERE m.title LIKE '%guerra de las galaxias%';