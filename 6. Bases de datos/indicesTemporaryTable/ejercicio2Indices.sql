/*
cree un indice_duracion sobre la columna length de la tabla movies
y otro indice_awards sobre las awards mejorando el acceso y el timepo de respuesta.
Elegi estos por que son campos por los que se puede querer filtrar las peliculas
y por que son valores que no deberian cambiar 
*/


explain select * from movies where awards=120;
explain select * from movies where awards=3;