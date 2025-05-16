
SELECT s.title, g.name FROM series s INNER JOIN genres g
ON s.genre_id = g.id;


SELECT e.title, a.first_name, a.last_name FROM episodes e
INNER JOIN actor_episode ae ON e.id = ae.episode_id
INNER JOIN actors a ON ae.actor_id = a.id;

SELECT s.title, COUNT(se.id) AS total_seasons
FROM series s
LEFT JOIN seasons se ON s.id = se.serie_id
GROUP BY s.title;

SELECT g.name, COUNT(g.id) AS total_peliculas FROM genres g 
LEFT JOIN movies p ON g.id = p.genre_id
GROUP BY g.name
HAVING COUNT(p.id) >= 3;

SELECT DISTINCT a.first_name, a.last_name
FROM actors a
JOIN actor_movie am ON a.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE '%La Guerra de las galaxias%'
GROUP BY a.id
HAVING COUNT(DISTINCT m.id) = (SELECT COUNT(*) FROM movies WHERE title LIKE '%La Guerra de las galaxias%');
