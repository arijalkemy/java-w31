-- Consulta 2: Mostrar los 3 planes de internet más económicos
SELECT *
FROM planes_internet
ORDER BY precio
LIMIT 3;