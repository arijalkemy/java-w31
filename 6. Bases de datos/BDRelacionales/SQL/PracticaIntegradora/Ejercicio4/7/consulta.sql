-- Consulta 7: Mostrar el promedio de precios de planes de internet contratados por personas de entre 20 y 30 años
SELECT AVG(p.precio) AS promedio_veintes
FROM planes_internet p
JOIN clientes c
ON p.id_plan = c.id_plan
WHERE TIMESTAMPDIFF(YEAR, c.fecha_nacimiento, CURDATE()) BETWEEN 20 AND 30;