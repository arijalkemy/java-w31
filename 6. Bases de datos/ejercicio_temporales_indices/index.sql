USE movies_db;

SELECT * FROM movies WHERE rating > 9;
EXPLAIN SELECT * FROM movies WHERE rating > 9;

CREATE INDEX movies_rating_idx ON movies (rating);
EXPLAIN SELECT * FROM movies WHERE rating > 9;

-- Dadas consultas anteriores, y teniendo en cuenta la logica de negocio, considero que buscar peliculas filtrando por rating
-- Usando el explain si se nota la diferencia entre usar o no usar el indice. 