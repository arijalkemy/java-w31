
/* Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”. */
DROP TEMPORARY TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD(
title VARCHAR(40),
number INT,
release_date DateTime,
rating Decimal(10,3),
temporally varchar(40),
serie varchar(40)
);

INSERT INTO TWD (title, number, release_date, rating, temporally, serie)
SELECT E.title, E.number, E.release_date, E.rating, S.title, SE.title 
FROM episodes AS E
JOIN seasons AS S ON S.id = E.season_id
JOIN series AS SE ON S.serie_id = SE.id
WHERE SE.title = 'The Walking Dead';


/* Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada. */

SELECT T.title, T.number, T.release_date, T.rating, T.temporally, T.serie FROM TWD AS T
 WHERE T.temporally = 'Primer Temporada';