USE movies_db;
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (
SELECT e.TITLE Episodio, s.TITLE Temporada
FROM episodes e
INNER JOIN seasons s ON e.SEASON_ID = s.ID
WHERE s.ID BETWEEN 20 AND 26);

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE Temporada = "Primer Temporada";

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
SELECT * FROM movies;
CREATE INDEX idx_release_date ON movies(RELEASE_DATE);
EXPLAIN SELECT * FROM movies WHERE RELEASE_DATE BETWEEN "2010-10-04" AND "2015-10-04";
EXPLAIN SELECT * FROM movies WHERE YEAR(RELEASE_DATE) = 2004;

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
/* El campo elegido se basa en que "simulamos" que nuestra BD se utilizaria para una API de ultimos estrenos de peliculas.
 Por lo tanto seria importante tener un indice en la fecha de estreno de la misma. */