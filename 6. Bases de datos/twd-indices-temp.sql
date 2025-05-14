# Ejercicio 1

# Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
# Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

create temporary table TWD (id int, created_at timestamp, updated_at timestamp, title varchar(500), number int, release_date datetime, rating decimal(3,1), season_id int, season_number int);

insert into TWD
(select e.*, sea.number as season_number
from episodes e
join seasons sea on e.season_id = sea.id
join series ser on ser.id = sea.serie_id
where ser.title like 'The Walking Dead');

select * from TWD;

select *
from TWD
where season_number = 1;

# Ejercicio 2

# En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
create index index_by_season_num
on seasons (number);

show index from seasons;

# Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
