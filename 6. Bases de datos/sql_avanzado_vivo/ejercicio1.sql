-- 1
SELECT 
    E.nombre, E.puesto, D.localidad 
FROM 
    empleado as E INNER JOIN Departamento 
    AS D ON E.depto_nro = D.depto_nro
WHERE
    E.puesto = "Vendedor";

-- 2
SELECT
    D.nombre_depto
FROM
    EMPLEADO AS E
JOIN
    DEPARTAMENTO AS D ON E.depto_nro = D.depto_nro
GROUP BY
    D.depto_nro, D.nombre_depto
HAVING
    COUNT(E.cod_emp) > 5;

-- 3
SELECT
    E.nombre,
    E.salario,
    D.nombre_depto
FROM
    EMPLEADO AS E
JOIN
    DEPARTAMENTO AS D ON E.depto_nro = D.depto_nro
WHERE
    E.puesto = (SELECT puesto FROM EMPLEADO WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- 4
SELECT
    E.*
FROM
    EMPLEADO AS E
JOIN
    DEPARTAMENTO AS D ON E.depto_nro = D.depto_nro
WHERE
    D.nombre_depto = 'Contabilidad'
ORDER BY
    E.nombre;

-- 5
SELECT
    nombre
FROM
    EMPLEADO
WHERE
    salario = (SELECT MIN(salario) FROM EMPLEADO);

-- 6
SELECT
    E.*
FROM
    EMPLEADO AS E
JOIN
    DEPARTAMENTO AS D ON E.depto_nro = D.depto_nro
WHERE
    D.nombre_depto = 'Ventas'
    AND E.salario = (SELECT MAX(salario) FROM EMPLEADO WHERE depto_nro = D.depto_nro);
