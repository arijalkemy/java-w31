USE empresa_internet;

-- 1. Listar todos los clientes
SELECT * FROM client;

-- 2. Obtener los contratos activos (endDate es NULL)
SELECT * FROM contract WHERE endDate IS NULL;

-- 3. Mostrar nombre y apellido de los clientes junto con el nombre de la ciudad
SELECT name, last_name, city FROM client;

-- 4. Listar todos los contratos con el nombre del cliente y el plan asociado
SELECT 
    contract.id_contract,
    client.name,
    client.last_name,
    plan.megas,
    plan.price
FROM contract
JOIN client ON contract.id_client = client.id_client
JOIN plan ON contract.id_plan = plan.id_plan;

-- 5. Contar cuántos contratos hay por cada plan
SELECT 
    plan.id_plan,
    plan.megas,
    COUNT(contract.id_contract) AS cantidad_contratos
FROM plan
LEFT JOIN contract ON plan.id_plan = contract.id_plan
GROUP BY plan.id_plan, plan.megas;

-- 6. Listar los clientes que viven en la ciudad 'Buenos Aires'
SELECT * FROM client WHERE city = 'Buenos Aires';

-- 7. Obtener los clientes nacidos después del año 1990
SELECT * FROM client WHERE birthDate > '1990-12-31';

-- 8. Listar los planes que tengan más de 100 megas y mostrar el descuento correspondiente
SELECT * FROM plan WHERE megas > 100;

-- 9. Mostrar todos los contratos que comenzaron en 2023
SELECT * FROM contract WHERE YEAR(starDate) = 2023;

-- 10. Calcular el total recaudado para cada plan (suma de price de todos los contratos activos por plan)
SELECT 
    plan.id_plan,
    plan.megas,
    SUM(plan.price) AS total_recaudado
FROM plan
JOIN contract ON plan.id_plan = contract.id_plan
WHERE contract.endDate IS NULL
GROUP BY plan.id_plan, plan.megas;