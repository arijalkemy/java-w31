use movies_db;

CREATE TEMPORARY TABLE TWD (serie varchar(50), episodio varchar(50), temporada int);
INSERT INTO TWD 
SELECT s.title , e.title, se.number
FROM series s JOIN seasons se
ON se.serie_id = s.id 
JOIN episodes e ON e.season_id = se.id
WHERE s.title LIKE '%The Walking Dead%';

SELECT * FROM TWD;

SELECT * FROM TWD WHERE temporada LIKE '%1%';

/*En la base de datos “movies”, seleccionar 
una tabla donde crear un índice y luego chequear la creación del mismo.
Analizar por qué crearía un índice en la tabla indicada y con qué criterio 
se elige/n el/los campos.*/

CREATE INDEX actor_episode_actor_id_idx ON actor_episode (actor_id);
/* Respuesta: se hacen muchas consultas buscando los episodios por un actor_id específico,
 un índice en esta columna mejorará el rendimiento */
 
 