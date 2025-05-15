/*Crear la tabla temporal TWD*/
CREATE TEMPORARY TABLE TWD (
    id INT,
    title VARCHAR(500),
    number INT,
    release_date DATETIME,
    season_number INT
);

/*Insertar en la tabla temporal los episodios de The Walking Dead*/
INSERT INTO TWD (id, title, number, release_date, season_number)
SELECT e.id, e.title, e.number, e.release_date, s.number
FROM episodes e
JOIN seasons s ON e.season_id = s.id
JOIN series sr ON s.serie_id = sr.id
WHERE sr.title = 'The Walking Dead';


/*Consultar la tabla temporal para ver los episodios de la temporada 1*/
SELECT * 
FROM TWD
WHERE season_number = 1;


