-- Seleccionar la tabla
USE movies_db;

-- Eliminar la tabla temporal TWD si existe
DROP TABLE IF EXISTS TWD;

-- Crear la tabla temporal
CREATE TEMPORARY TABLE TWD(
	id_episode INT UNSIGNED PRIMARY KEY,
    title_episode VARCHAR(500),
    number_season INT UNSIGNED
);

-- Insertar todos los episodios de TWD en la tabla
INSERT INTO TWD (id_episode, title_episode, number_season)
	SELECT
		e.id,
        e.title,
        s.number
	FROM episodes e
    INNER JOIN seasons s ON e.season_id = s.id
    WHERE s.title = 'The Walking Dead';

-- Seleccionar los episodios de la temporada 1 de TWD
SELECT
	id_episode AS 'ID',
	title_episode AS 'Episodio',
    number_season AS 'Temporada'
FROM TWD
WHERE number_season = 1;