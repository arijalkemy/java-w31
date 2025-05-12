-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title AS Titulo, g.name as Genero from series s LEFT JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title AS Titulo_espisodio, a.first_name AS Nombre, a.last_name AS Apellido 
FROM episodes e 
LEFT JOIN actor_episode ae ON e.id = ae.episode_id 
LEFT JOIN actors a ON a.id = ae.actor_id 
ORDER BY e.title;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title as Titulo, COUNT(se.id) FROM series s LEFT JOIN seasons se on s.id = se.serie_id GROUP BY s.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT g.name AS Genero, COUNT(m.id) as Cantidad 
FROM genres g INNER JOIN movies m 
ON g.id = m.genre_id
GROUP BY g.id HAVING COUNT(m.id) > 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT CONCAT(a.first_name, " ", a.last_name) as Actor
FROM actors a 
INNER JOIN actor_movie am ON a.id = am.actor_id 
INNER JOIN movies m on m.id = am.movie_id
WHERE m.title LIKE "La Guerra de las galaxias%"
GROUP BY Actor
HAVING COUNT(m.id) = (SELECT COUNT(*) 
                      FROM movies 
                      WHERE title LIKE 'La Guerra de las galaxias%');
                      


select * from movies