use movies_db;

/*
	Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
*/
DROP TABLE IF exists twd;
CREATE TEMPORARY TABLE twd(
	SELECT e.id, e.title, e.number, e.release_date, e.rating, e.season_id, s.number as "serie_number"
	FROM episodes e
	INNER JOIN seasons s ON e.season_id = s.id
	INNER JOIN series se ON se.id = s.serie_id
	WHERE se.title = "The Walking Dead"
);

# Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM twd WHERE serie_number = 1;

# En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX index_length
ON movies (length);

SHOW INDEX FROM movies;

/*
	Hacer un index en length es buena idea porque se puede ordenar por extensión de la pelicula y el tipo de la columna es numérico.
*/