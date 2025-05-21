/*
Sql avanzado
Ejercicio 2
*/

select series.title, genres.name 
from series inner join genres
on series.genre_id = genres.id;

SELECT episodes.title AS episode_title, actors.first_name, actors.last_name
FROM episodes INNER JOIN  actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

select series.title as title, count(*) as seasons
from series inner join seasons
on series.id = seasons.serie_id
group by title;

select genres.name as genre, count(*) movies_quantity
from genres inner join movies on genres.id = movies.genre_id
group by genre
having count(*) >= 3;

select DISTINCT actors.first_name AS name,
                actors.last_name AS last
from actors
inner join actor_movie on actors.id = actor_movie.actor_id
inner join movies on actor_movie.movie_id = movies.id
where movies.title like '%La guerra de las galaxias%'
group by actors.id
HAVING COUNT(DISTINCT movies.id) = (
    SELECT COUNT(DISTINCT m2.id)
    FROM movies m2
    WHERE m2.title LIKE '%La guerra de las galaxias%');




