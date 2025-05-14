USE movies_db;

-- Ejercicio 1
-- 1. Crear una tabla temporal llamada “TWD” 
-- CREATE TEMPORARY TABLE TWD
DROP TABLE IF EXISTS TWD;

CREATE TEMPORARY TABLE TWD(
  `id` int(10) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number` int(10) unsigned DEFAULT NULL,
  `release_date` datetime NOT NULL,
  `rating` decimal(3,1) NOT NULL,
  `season_id` int(10) unsigned DEFAULT NULL,
  `season_number` int(10) unsigned DEFAULT NULL
);

INSERT INTO TWD SELECT e.* , se.number as season_number
FROM series s JOIN seasons se ON s.id = se.serie_id
JOIN episodes e ON se.id = e.season_id
WHERE s.title LIKE 'The Walking Dead';


-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD
WHERE season_number = 1;

-- Ejercicio 2

-- 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.

-- 
SHOW INDEX FROM movies;
DROP INDEX idx_movies_title ON movies;

EXPLAIN SELECT * FROM movies WHERE title LIKE 'A%';

-- title es un campo frecuentemente consultado por los usuarios.
CREATE INDEX idx_movies_title ON movies(title);
-- Verifica
EXPLAIN SELECT * FROM movies WHERE title LIKE 'A%';
SELECT * FROM movies WHERE title LIKE 'A%';


