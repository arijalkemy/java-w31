USE `empresa_internet`;

SELECT * FROM cliente;
SELECT * FROM plan_internet;

-- Obtener apellido, nombre y dni de los clientes, ordenado por el apellido
SELECT apellido, nombre, dni FROM cliente ORDER BY apellido;

-- Obtener id, precio, descueno y dni_cliente de los planes de internet que tengan 150 o más megas
SELECT id, precio, descuento, dni_cliente FROM plan_internet WHERE velocidad >= 150;

-- Obtener todos los datos de los primeros 5 clientes
SELECT * FROM cliente LIMIT 5;
 
 -- Obtener los diferentes valores de descuento en los planes de internet 
SELECT DISTINCT descuento FROM plan_internet ORDER BY descuento DESC;

-- Obtener id, velocidad, precio, descuento, nombre del cliente, apellido del cliente por cada plan de internet
SELECT p.id, p.velocidad, p.precio, p.descuento, c.nombre, c.apellido
FROM plan_internet p
INNER JOIN cliente c ON p.dni_cliente = c.dni;

-- Obtener todos los datos de los clientes cuya ciudad inicien con c/C
SELECT * FROM cliente WHERE LOWER(ciudad) LIKE "c%";

-- Obtener el precio promedio de los planes de internet
SELECT AVG(precio) FROM plan_internet; 

-- Obtener la cantidad de clientes
SELECT COUNT(*) FROM cliente;

-- Obtener todos los datos del cliente mas joven
SELECT * from cliente
WHERE fecha_nacimiento=(SELECT MIN(fecha_nacimiento) FROM cliente);

-- Obtener los ingresos percibidos por todos los planes de internet
SELECT SUM(precio) FROM plan_internet;