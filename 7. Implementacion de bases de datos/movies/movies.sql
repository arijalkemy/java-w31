SELECT * 
FROM actors
WHERE favorite_movie_id IS NOT NULL;

SELECT a.first_name, a.last_name, m.title, m.rating
FROM actors AS a
JOIN actor_movie AS ma ON a.id = ma.actor_id
JOIN movies AS m ON ma.movie_id = m.id;

SELECT first_name, last_name, rating 
FROM actors
WHERE rating > 7.0;

SELECT a.first_name, a.last_name, m.title
FROM actors AS a
JOIN actor_movie AS am ON am.actor_id = a.id
JOIN movies AS m ON am.movie_id = m.id
WHERE m.title = "Avatar";

SELECT m.title, a.first_name, a.rating AS rating_actor
FROM movies AS m
JOIN actor_movie AS am ON am.movie_id = m.id
JOIN actors AS a ON a.id = am.actor_id
WHERE a.rating > 7;

SELECT m.title, g.name
FROM movies AS m
JOIN genres AS g ON g.id = m.genre_id
WHERE g.name = "Drama";







