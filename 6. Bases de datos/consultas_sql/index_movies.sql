-- Crear un indice compuesto en la tabla episodes
CREATE INDEX idx_episodes_season_number 
ON episodes (season_id, number);

-- Verificar la creacion 
SHOW INDEX FROM episodes;
/*¿Por qué crear el índice? La tabla episodes suele ser consultada frecuentemente para obtener episodios de una temporada 
específica y ordenarlos por número. El indice mejora  la velocidad de estas consultas al evitar escaneos completos de la tabla
Criterio de selección de campos:
-season_id: Permite filtrar los episodios por temporada
-number: Permite ordenar los episodios dentro de una temporada
El indice compuesto garantiza que las consultas con ambos criterios sean rápidas y eficientes.*/