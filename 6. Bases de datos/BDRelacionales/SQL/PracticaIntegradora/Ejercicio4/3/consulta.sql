-- Consulta 3: Mostrar los 3 planes de internet que ofrecen mayor velocidad
SELECT *
FROM planes_internet
ORDER BY velocidad DESC
LIMIT 3;
