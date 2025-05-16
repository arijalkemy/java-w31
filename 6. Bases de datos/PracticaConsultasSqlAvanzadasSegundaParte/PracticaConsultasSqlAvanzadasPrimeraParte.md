# Practica Consultas Avanzadas 

## _Consigna Primera parte_


Responder las siguientes preguntas:

1.  **¿A qué se denomina JOIN en una base de datos y para qué se utiliza?** 
	- Se utiliza para obtener datos de varias tablas relacionadas entre sí. Consiste en combinar datos de una tabla con datos de la otra tabla, a partir de una o varias condiciones en común.

2.  **Explicar dos tipos de JOIN.**

	- Inner Join se utiliza para traer los datos relacionados de dos o más tablas.
	-	Left Join se utiliza para traer los datos de la tabla izquierda más los relacionados de la tabla derecha.

3. **¿Para qué se utiliza el GROUP BY?**

   - Agrupa los resultados según las columnas indicadas.
	-	Genera un solo registro por cada grupo de filas que compartan las 		columnas indicadas.
	-	Reduce la cantidad de filas de la consulta.
	-	Se suele utilizar en conjunto con funciones de agregación, para obtener datos resumidos y agrupados por las columnas que se necesiten.

4.  **¿Para qué se utiliza el HAVING?**

	- La cláusula HAVING se utiliza para incluir condiciones con algunas funciones SQL.
	- Afecta a los resultados traidos por Group By.

5.  **Escribir una consulta genérica para cada uno de los siguientes diagramas:**

	- ![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXcjJCBRFGx4_y0AMYQXyJGyRWS6RDnfDJCRp-hDN_900wH0bm6meoxtHGShJGbamgRNmrEF9kIn7sIaETVifH4oLz9F8MoKv64oLxsG3hbU0lk74JHRw9L7fG_J2KScZW4yciSOXb_EcyvHjC53S5y4uLVN7yUCjp1BYsyVluqOn9RUEb0uYDk?key=4nnCjYT22SbR07y0Udz9oA)![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXdRrsrluORARRmt69PEs3Hb5c3dSuMxPKBAvgI1wtLBVs65KKAiuiZVFXFgrWN6LJTjei--bpJpNx3-tTxchROD8fsVKRraXPK2LY2mw0j-hTdwCOopLro9JrHqh1DqhJiyBbKfNJja-OHqU3DTUD_3E93R2DwdXwS_ooE08Xu4Xbtlb1IR3rs?key=4nnCjYT22SbR07y0Udz9oA)
		1. `SELECT movies.*, actors.first_name, actors.last_name
FROM movies INNER JOIN actors
ON movies.id = actors.favorite_movie_id;`

		2. `SELECT * FROM movies mo LEFT JOIN actors ac ON mo.id = ac.favorite_movie_id;`

## _Consigna segunda parte_
Dada la base de datos **movies**

![der](https://i.postimg.cc/RCwk1NJ0/movies-db-diagram.png)
Se propone realizar las siguientes consultas
1.  Mostrar el título y el nombre del género de todas las series.
2.  Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
3.  Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
4.  Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
5.  Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

- ## Consultas
	>1. Mostrar el título y el nombre del género de todas las series.

	`SELECT s.title, g.name FROM series AS s INNER JOIN genres AS g ON s.genre_id = g.id;`

	>2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

	`SELECT e.title, a.first_name, a.last_name FROM episodes AS e INNER JOIN actor_episode AS ae ON e.id = ae.episode_id INNER JOIN actors as a 
ON a.id = ae.actor_id;`

	>3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

	`SELECT s.title, COUNT(*) AS ``Number of Seasons``
FROM series AS s
JOIN seasons AS se ON s.id = se.serie_id
GROUP BY s.title;`

	>4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

	`SELECT g.name, COUNT(*) AS ``Cantidad total de peliculas``
FROM genres AS g
INNER JOIN movies AS m ON g.id = m.genre_id
GROUP BY g.name
HAVING ``Cantidad total de peliculas`` >= 3;`

	>5.  Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan..

	`SELECT DISTINCT a.first_name, a.last_name
	FROM actors a 
	INNER JOIN actor_movie am 
	ON am.actor_id = a.id 
	INNER JOIN movies m ON m.id = am.movie_id
	WHERE LOWER(m.title) LIKE LOWER('La guerra de las galaxias%');`

