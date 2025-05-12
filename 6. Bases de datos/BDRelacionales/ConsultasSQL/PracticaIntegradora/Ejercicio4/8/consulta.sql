-- Consulta 8: Mostrar la provincia con mayor cantidad de clientes
SELECT provincia, COUNT(*) AS total_clientes
FROM clientes
GROUP BY provincia
ORDER BY total_clientes DESC
LIMIT 1;