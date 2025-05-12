-- Consulta 10: Mostrar los clientes ordenados por precio descendente de los planes de internet que contratan
SELECT c.nombre, c.apellido, p.id_plan, p.velocidad, p.precio, p.descuento
FROM clientes c
JOIN planes_internet p
ON p.id_plan = c.id_plan
ORDER BY p.precio DESC;