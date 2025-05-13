-- Selecciono la base de datos
USE movies_db;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT 
  e.title AS 'Episode title', 
  a.first_name AS 'Actor name', 
  a.last_name AS 'Actor last name'
FROM actor_episode i
LEFT JOIN actors a ON a.id = i.actor_id
LEFT JOIN episodes e ON e.id = i.episode_id;