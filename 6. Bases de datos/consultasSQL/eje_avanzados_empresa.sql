-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
SELECT CONCAT(e.nombre, " ", e.apellido) AS Nombre, e.puesto as Puesto, d.localidad
FROM empleado e 
INNER JOIN departamento d
ON e.depto_numero = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro AS Numero_depto, d.nombre_depto as Nombre_departamento, COUNT(e.cod_emp) AS Cantidad_empleados
FROM departamento d INNER JOIN empleado e ON e.depto_numero = d.depto_nro
GROUP BY d.depto_nro
HAVING count(e.cod_emp) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT CONCAT(e.nombre, " ", e.apellido) as Nombre , e.salario, d.nombre_depto
FROM empleado e INNER JOIN departamento d
ON e.depto_numero = d.depto_nro 
WHERE e.puesto = (SELECT puesto from empleado where nombre = 'Mito' AND apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT CONCAT(e.nombre, " ", e.apellido) FROM empleado e INNER JOIN departamento d
ON e.depto_numero = d.depto_nro WHERE d.nombre_depto = "Contabilidad" ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT CONCAT(nombre, ' ', apellido) AS nombre_empleado, salario
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM empleado e
INNER JOIN departamento d ON e.depto_numero = d.depto_nro 
WHERE e.salario = (
    SELECT MAX(e2.salario) 
    FROM empleado e2
    INNER JOIN departamento d2 ON e2.depto_numero = d2.depto_nro
    WHERE d2.nombre_depto = 'Ventas'
) AND d.nombre_depto = 'Ventas';

