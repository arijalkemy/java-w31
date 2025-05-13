# 1
SELECT * FROM movies_db.movies;
# 2
SELECT first_name, last_name, rating FROM movies_db.actors;
# 3
SELECT title as titulo FROM movies_db.series;
# 4
SELECT first_name, last_name FROM movies_db.actors WHERE rating > 7.5;
# 5
SELECT title, rating, awards FROM movies_db.movies WHERE rating > 7.5 AND awards > 2;
# 6
SELECT title, rating FROM movies_db.movies ORDER BY rating;
# 7
SELECT title FROM movies_db.movies LIMIT 3;
# 8
SELECT title, rating FROM movies_db.movies ORDER BY rating DESC LIMIT 5;
# 9
SELECT first_name, last_name FROM movies_db.actors LIMIT 10;
# 10
SELECT title, rating FROM movies_db.movies WHERE title LIKE "%Toy Story%";
# 11
SELECT first_name, last_name FROM movies_db.actors WHERE first_name LIKE "Sam%";
# 12
SELECT title FROM movies_db.movies WHERE release_date BETWEEN "2004-01-01" AND "2008-12-31";
# 13
SELECT title FROM movies_db.movies WHERE awards > 1 AND rating > 3 AND release_date BETWEEN "1988-01-01" AND "2009-12-31" ORDER BY rating;