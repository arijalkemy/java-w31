-- Calcular precio promedio de los planes de internet
SELECT AVG(precio) AS precio_promedio
FROM plan;

-- Traer planes con descuento mayor a 10 %
SELECT idx_plan As MayorA10
FROM plan
WHERE descuento > 10;

-- Obtener el plan mas caro
SELECT idx_plan, megas, precio
FROM plan
ORDER BY precio DESC
LIMIT 1;

-- Obtener el número total de planes disponibles
SELECT COUNT(*) AS total_planes
FROM plan;

-- Obtener clientes y sus planes de internet
SELECT c.id, c.nombre, c.apellido, p.idx_plan, p.megas, p.precio
FROM client c
JOIN plan p ON c.plan_id = p.id;

-- Obtener cantidad de clientes por cada plan
SELECT p.idx_plan, COUNT(c.id) AS total_clientes
FROM plan p
LEFT JOIN client c ON p.id = c.plan_id
GROUP BY p.idx_plan;
1





