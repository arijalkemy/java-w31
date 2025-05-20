-- EJERCICIO 1
-- SELECT * FROM movies

-- EJERCICIO 2
-- SELECT first_name, last_name, rating FROM actors

-- EJERCICIO 3
-- SELECT title AS titulo FROM series AS series

-- EJERCICIO 4
-- SELECT first_name, last_name FROM actors WHERE rating > 7.5

-- EJERCICIO 5
-- SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2 

-- EJERCICIO 6
-- SELECT title, rating FROM movies ORDER BY rating ASC

-- EJERCICIO 7
-- SELECT title FROM movies LIMIT 3

-- EJERCICIO 8
-- SELECT * FROM movies ORDER BY rating DESC LIMIT 5

-- EJERCICIO 9
-- SELECT * FROM actors LIMIT 10

-- EJERCICIO 10
-- SELECT title, rating FROM movies WHERE title LIKE "%Toy story%"

-- EJERCICIO 11
-- SELECT * FROM actors WHERE first_name LIKE "Sam%"

-- EJERCICIO 12
-- SELECT title FROM movies WHERE release_date >= "2004-01-01" AND release_date <= "2008-12-31"

-- EJERCICIO 13
/* SELECT title FROM movies 
WHERE release_date >= "1988-01-01" AND release_date <= "2009-12-31" AND
rating > 3 AND
awards > 1
ORDER BY rating DESC */