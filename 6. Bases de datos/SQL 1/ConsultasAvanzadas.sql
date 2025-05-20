-- EJERCICIO 1
/* SELECT s.title, g.name FROM series s
JOIN genres g ON s.genre_id = g.id */

-- EJERCICIO 2
/* SELECT e.title, a.first_name, a.last_name FROM episodes e
JOIN actor_episode ae ON e.id = ae.episode_id
JOIN actors a ON a.id = ae.actor_id */

-- EJERCICIO 3
/* SELECT s.title, COUNT(*) FROM series s
JOIN seasons ss ON s.id = ss.serie_id
GROUP BY ss.serie_id */

-- EJERCICIO 4
/* SELECT g.name, COUNT(*) FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY m.genre_id
HAVING COUNT(*) >= 3 */

-- EJERCICIO 5
/* SELECT DISTINCT a.first_name, a.last_name FROM movies m
JOIN actor_movie am ON am.movie_id = m.id
JOIN actors a ON a.id = am.actor_id
WHERE m.title LIKE "La Guerra de las galaxias%" */