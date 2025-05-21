drop temporary table if exists TWD;
create temporary table TWD(title varchar(40), season integer);

insert into TWD select episodes.title, episodes.season_id
from episodes 
join seasons on seasons.id = episodes.season_id 
join series on seasons.serie_id = series.id 
where series.title = "The Walking Dead";

select * from seasons where serie_id = 3;
select * from series;
select * from episodes where season_id = 20;

select title 
from TWD
where season = (select min(seasons.id)
				from seasons join series on seasons.serie_id = series.id
				where series.title = "The Walking Dead");

