-- Consulta 6: Mostrar todos los planes de internet contratados por personas en Buenos Aires
SELECT DISTINCT p.id_plan, p.velocidad, p.precio, p.descuento
FROM planes_internet p
JOIN clientes c
ON p.id_plan = c.id_plan
WHERE c.provincia = 'Buenos Aires';
