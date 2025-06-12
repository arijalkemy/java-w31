USE movies_db;


-- 1 Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (
		title VARCHAR(200),
        season INT
);

INSERT INTO TWD SELECT e.title, s.number from episodes e
JOIN seasons s ON e.season_id = s.id
JOIN series se ON s.serie_id = se.id
WHERE se.id = 3;

SELECT * FROM TWD;


-- 2 Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE season = 1;

-- DROP TABLE TWD;