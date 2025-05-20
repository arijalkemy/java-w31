CREATE TEMPORARY  TABLE episodios_por_temporada_twd(nombreCapitulo varchar(50), temporada varchar(50));

INSERT INTO episodios_por_temporada_twd SELECT e.title, se.title FROM episodes e
JOIN seasons se ON e.season_id = se.id
JOIN series s ON se.serie_id = s.id
WHERE s.title = "The walking dead"