# Agregar una película a la tabla movies.
select *
from movies;

insert into movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
values (null, null, 'Interstellar', 9.0, 6, '2014-07-04 00:00:00', 290, 5);

# Agregar un género a la tabla genres.
insert into genres (created_at, updated_at, name, ranking, active) 
values (null, null, 'Thriller', 13, 1);

select *
from genres;

# Asociar a la película del punto 1. genre el género creado en el punto 2.
update movies
set genre = 13
where title like 'Interstellar';

# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors
set favorite_movie_id = 22
where id = 1;

# Crear una tabla temporal copia de la tabla movies.
create temporary table movies_copy (id int, created_at timestamp, updated_at timestamp, title varchar(500), raiting decimal(3,1), awards int, release_date datetime, length int, genre_id int);

insert into movies_copy 
(select *
from movies);

select *
from movies_copy;

# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from movies_copy
where awards < 5;

# Obtener la lista de todos los géneros que tengan al menos una película.
select g.name
from genres g
join movies m on m.genre_id = g.id
group by g.id
having count(*) >= 1;

# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select a.*
from actors a
join movies m on a.favorite_movie_id = m.id
where m.awards > 3;

# Crear un índice sobre el nombre en la tabla movies.
create index index_by_title
on movies (title);

# Chequee que el índice fue creado correctamente.
show index from movies;

# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
