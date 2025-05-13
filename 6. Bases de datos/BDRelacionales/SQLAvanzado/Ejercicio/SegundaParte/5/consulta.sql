-- Selecciono la base de datos
USE movies_db;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT 
    a.first_name AS 'Star Wars actor first name',
    a.last_name AS 'Star Wars actor last name'
FROM actor_movie i
INNER JOIN actors a ON a.id = i.actor_id
INNER JOIN movies m ON m.id = i.movie_id
WHERE m.title LIKE '%La Guerra de las galaxias%'
GROUP BY a.id, a.first_name, a.last_name
HAVING COUNT(DISTINCT m.id) = (
    SELECT COUNT(*) 
    FROM movies 
    WHERE title LIKE '%Star Wars%'
);