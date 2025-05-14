# Practica Consultas (Movies)
![der](https://i.postimg.cc/RCwk1NJ0/movies-db-diagram.png)

## _Consigna_

Se propone realizar las siguientes consultas a la base de datos movies_db.sql. Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas

## _Solucionario_

- **Mostrar todos los registros de la tabla de movies.**
	- `SELECT * FROM movies;` 
	
- **Mostrar el nombre, apellido y rating de todos los actores.**
	- `SELECT first_name, last_name, rating FROM actors a`
	
- **Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.**
	- `SELECT first_name, last_name, rating FROM actors a`
	
- **Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.**
	- `SELECT first_name, last_name, rating FROM actors a where a.rating > 7.5;`
	
- **Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.**
	- `SELECT title, rating, awards FROM movies m where m.rating > 7.5 AND m.awards > 2;`

- **Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.**
	- `SELECT title, rating FROM movies m ORDER BY rating ASC;`

- **Mostrar los títulos de las primeras tres películas en la base de datos.**
	- `SELECT title FROM movies m LIMIT 3;`
	
- **Mostrar el top 5 de las películas con mayor rating.**
	- `SELECT * FROM movies m ORDER BY m.rating DESC LIMIT 5;`
	
- **Listar los primeros 10 actores.**
	- `SELECT * FROM actors a LIMIT 10;`
	
- **Mostrar el título y rating de todas las películas cuyo título sea de Toy Story**
	- `SELECT title, rating FROM movies m WHERE m.title = 'Toy Story';`

- **Mostrar a todos los actores cuyos nombres empiezan con Sam.**
	- `SELECT * FROM actors a WHERE a.first_name LIKE 'sam%';`

- **Mostrar el título de las películas que salieron entre el 2004 y 2008.**
	- `SELECT title FROM movies m WHERE m.release_date >= '2004-01-01' AND m.release_date <= '2008-12-31'`

- **Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.**
	- `SELECT * FROM movies m  WHERE m.release_date >= '1988-01-01' 
	AND m.release_date <= '2009-12-31' 
	AND m.rating > 3 
	AND m.awards >= 1 ORDER BY m.rating;`  


