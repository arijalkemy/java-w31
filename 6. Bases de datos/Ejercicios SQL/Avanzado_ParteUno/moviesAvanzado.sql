Se propone realizar las siguientes consultas a la base de datos movies_db.sql trabajada en la primera clase.
Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas:

-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title AS titulo, g.name AS nombre_genero
FROM series s
JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los 
-- actores que trabajan en cada uno de ellos.
SELECT e.title AS titulo_episodio, a.first_name, a.last_name
FROM episodes e
JOIN actor_episode ae ON e.id = ae.episode_id
JOIN actors a ON ae.actor_id = a.id;

-- Mostrar el título de todas las series y el total de 
-- temporadas que tiene cada una de ellas.
SELECT s.title AS titulo_serie, COUNT(se.id) AS total_temporadas
FROM series s
LEFT JOIN seasons se ON s.id = se.serie_id
GROUP BY s.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas 
-- por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name AS nombre_genero, COUNT(m.id) AS total_peliculas
FROM genres g
LEFT JOIN movies m ON g.id = m.genre_id
GROUP BY g.id
HAVING total_peliculas >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas 
-- de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
JOIN actor_movie am ON a.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE '%La Guerra de las galaxias%';

