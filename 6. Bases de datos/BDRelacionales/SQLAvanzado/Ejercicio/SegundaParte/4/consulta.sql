-- Selecciono la base de datos
USE movies_db;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT
	g.name AS 'Genre name',
    COUNT(m.id) AS 'Total movies'
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING COUNT(m.id) >= 3;