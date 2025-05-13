-- Selecciono la base de datos
USE movies_db;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT
	s.title,
    COUNT(t.id) AS 'Number of seasons'
FROM series s
INNER JOIN seasons t ON s.id = t.serie_id
GROUP BY s.title;