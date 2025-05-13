
-- EJERCICIO 1
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD”
-- y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

DROP TEMPORARY TABLE TWD;
CREATE TEMPORARY TABLE TWD (
    id INT PRIMARY KEY,
    serie VARCHAR(50),
    episode_name VARCHAR(100),
    id_season INT,
    season VARCHAR(50)
);

INSERT INTO TWD (id, serie, episode_name, id_season, season) SELECT e.id, se.title ,e.title , s.number, s.title FROM episodes e
INNER JOIN seasons s ON e.season_id = s.id
INNER JOIN series se ON se.id = s.serie_id
WHERE se.title = "The Walking Dead";

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada
SELECT * FROM TWD WHERE id_season = 1;


-- EJERCICIO 2

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX episodes_idx
ON episodes (id);

SHOW INDEX FROM episodes;
