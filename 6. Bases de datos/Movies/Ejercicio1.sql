USE movies_db;

SELECT * FROM movies;

SELECT first_name, last_name, rating from actors;

SELECT title 'títulos' FROM series;

SELECT first_name, last_name from actors
WHERE rating > 7.5;

SELECT title, rating, awards FROM movies
WHERE rating > 7.5
AND awards > 2;

SELECT title, rating FROM movies
ORDER BY rating ASC;

SELECT title FROM movies LIMIT 3;

SELECT * FROM movies
ORDER BY rating DESC
LIMIT 5;

SELECT * from actors
LIMIT 10;

SELECT title, rating FROM movies
WHERE title LIKE 'Toy Story%';

SELECT * FROM actors
WHERE first_name LIKE 'Sam%';

SELECT title FROM movies
WHERE release_date BETWEEN '20040101' AND '20081231';

SELECT title FROM movies
WHERE rating > 3 AND awards > 1
AND release_date BETWEEN '19880101' AND '20091231'
ORDER BY rating;
