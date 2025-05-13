USE movies_db;

/*Mostrar el título y el nombre del género de todas las series.*/
SELECT se.title , ge.name
FROM series se
JOIN genres ge
ON se.genre_id = ge.id;
/* Mostrar el título de los episodios, el nombre y apellido de los actores 
que trabajan en cada uno de ellos.*/
SELECT e.title, ac.first_name, ac.last_name
FROM episodes e
JOIN actor_episode ace
ON e.id = ace.episode_id
JOIN actors ac
ON ace.id = ace.actor_id;

/*_Mostrar el título de todas las series y el total de temporadas que tiene cada una 
de ellas.*/
SELECT se.title AS titulo_serie, COUNT(*) AS total_temporadas
FROM seasons s
JOIN series se ON s.serie_id = se.id
GROUP BY se.title;

/*Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno,
 siempre que sea mayor o igual a 3.*/
SELECT ge.name AS genero_nombre, COUNT(*) AS total_de_peliculas
FROM genres ge
JOIN movies mov ON mov.genre_id = ge.id
GROUP BY ge.name
HAVING total_de_peliculas >= 3;
 
/*Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas 
de la guerra de las galaxias y que estos no se repitan.*/
SELECT act.first_name, act.last_name
FROM actors act
JOIN actor_movie actmov ON act.id = actmov.actor_id
JOIN movies mov ON mov.id = actmov.movie_id
WHERE mov.title LIKE "%La guerra de las Galaxias%"
GROUP BY act.id, act.first_name, act.last_name
HAVING COUNT(DISTINCT mov.id) = (
    SELECT COUNT(*) FROM movies WHERE title LIKE "%La guerra de las Galaxias%");


