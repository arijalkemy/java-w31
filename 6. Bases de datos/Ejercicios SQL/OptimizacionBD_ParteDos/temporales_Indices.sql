-- Ejercicio 1
CREATE TEMPORARY TABLE TWD AS
SELECT e.id AS episode_id, e.title AS episode_title, s.title AS season_title, s.number AS season_number
FROM episodes e
JOIN seasons s ON e.id = s.id
JOIN series se ON s.id = se.id
WHERE se.title = 'The Walking Dead';

--Consulta
SELECT *
FROM TWDd
WHERE season_number = 3;

-- Ejercicio 2
-- Hice un indice para el realese date de las movies
-- lo probe con esta consulta y solo ejecuta una row
EXPLAIN SELECT *
FROM movies
WHERE release_date > '2020-01-01';
-- Despues lo probe eliminando el indice, y ahi si escanea las 21 rows