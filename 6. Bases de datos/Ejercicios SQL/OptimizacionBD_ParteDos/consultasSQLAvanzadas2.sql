
-- 1) Agregar una película a la tabla movies.
INSERT INTO movies (title, release_date, length, rating, awards, genre_id)
VALUES ('Nueva Película', '2023-10-01', 120, 8.7, 5, NULL);

-- 2) Agregar un género a la tabla genres.
INSERT INTO genres (name) VALUES ('Nuevo Género');

-- 3) Asociar a la película del punto 1. genre el género creado en el punto 2.
SELECT id FROM genres WHERE name = 'Nuevo Género';
Supongamos que el id resulta ser 1. Ahora puedes actualizar la película:
UPDATE movies 
SET genre_id = 1 
WHERE title = 'Nueva Película';

-- 4) Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors 
SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'Nueva Película') 
WHERE id = 1;

-- 5) Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies AS 
SELECT * FROM movies;

-- 6) Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM temp_movies 
WHERE awards < 5;

-- 7) Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name 
FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY g.id;

-- 8) Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name 
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9) Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_movie_title ON movies(title);

-- 10) Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11) En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

Análisis:

Mejora del Rendimiento en Consultas: La creación de un índice en el campo title de la 
tabla movies mejoraría significativamente el rendimiento de las consultas que buscan o 
filtran por el título de la película. Sin un índice, la base de datos tendría que realizar 
un escaneo completo de la tabla para encontrar coincidencias.

Costo en Escrituras: Sin embargo, cada índice añadido aumenta el tiempo requerido para 
insertar, actualizar o eliminar registros, ya que el índice también necesita ser actualizado. 
Por lo tanto, la mejora en la lectura se tiene que equilibrar con el impacto en las operaciones 
de escritura.

Conclusión: En la mayoría de los casos, la creación de índices en campos 
frecuentemente consultados resulta en una mejora notable del rendimiento.

-- 12) ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

Sugerencia:

Tabla actors: Consideraría crear un índice en el campo favorite_movie_id de la tabla actors.
Justificación:

Consultas Frecuentes: El campo favorite_movie_id podría ser utilizado frecuentemente 
para buscar actores favoritos y asociarlos a películas. Esto podría hacerlo más eficiente 
para las consultas donde los actores están relacionados con sus películas favoritas.

Cardinalidad: Si existen muchos actores en la base de datos, un índice en favorite_movie_id 
acelerará las búsquedas que involucren este campo, mejorando el rendimiento general de esas 
consultas.