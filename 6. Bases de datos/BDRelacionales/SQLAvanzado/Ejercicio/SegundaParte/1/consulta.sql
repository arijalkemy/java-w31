-- Selecciono la base de datos
USE movies_db;

-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s
INNER JOIN genres g
ON s.genre_id = g.id;