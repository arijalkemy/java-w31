select * from movies;
select * from genres;
select * from actors;

insert into movies 
values (22,'2023-10-05 15:30:00', '2023-10-05 15:30:00', 'Inception', 8.8, 4, '2010-07-16', 148, 2);

insert into genres
values (13, '2023-10-05 15:30:00', '2023-10-05 15:30:00', 'Science', 13, true);

update movies set genre_id = 13 where id = 22;

update actors set favorite_movie_id = 22 where id = 49;

CREATE TEMPORARY TABLE temporal_movies AS
SELECT * FROM movies;

select * from temporal_movies;

SET SQL_SAFE_UPDATES = 0;
delete from temporal_movies where awards < 5;

select genres.name
from genres
join movies on movies.genre_id = genres.id;

select actors.first_name
from actors
join movies on movies.id = actors.favorite_movie_id
where movies.awards > 3;

/*
Creo el indice en la tabla movies sobre el titulo al crear este indice la busqueda mejora ya que es mas rapida y eficiente
ya no recorre las 22 rows.
Se podria mejorar mas las busquedas en movies si agregamos otros indices como por ejemplo un indice por rating, acelerando mas las busquedas.
Siempre y cuando prestando atencion siemrpe a sie sta tabla es actualizada con frecuencia ya que ahi no seria tan correcto crear tantos indices.alter

Se pueden crear indices en la tabla de series por ejemplo apra mejorar y acelerar las busquedas en la misma, por ejemplo un indice sobre el nombre
de la serie. 
*/
explain select title from movies where title = "Titanic"; 
