--
-- CONSULTAS
--

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT emp.nombre, emp.puesto, dep.localidad
FROM empleado emp
INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro
WHERE emp.puesto LIKE "Vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT dep.depto_nro, dep.nombre_depto, dep.localidad
FROM Departamento dep
INNER JOIN Empleado emp ON dep.depto_nro = emp.depto_nro
GROUP BY dep.depto_nro, dep.nombre_depto, dep.localidad
HAVING COUNT(emp.cod_emp) > 5;

-- Visualizar los departamentos con más de un empleado.
SELECT dep.depto_nro, dep.nombre_depto, dep.localidad, COUNT(emp.cod_emp) AS cantidad_empleados
FROM Departamento dep INNER JOIN Empleado emp
ON dep.depto_nro = emp.depto_nro
GROUP BY dep.depto_nro, dep.nombre_depto, dep.localidad
HAVING cantidad_empleados > 1;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT emp.nombre, emp.salario, dep.nombre_depto
FROM empleado emp
INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro
WHERE emp.puesto LIKE (
	SELECT emp.puesto FROM empleado emp WHERE emp.nombre LIKE 'Mito' AND emp.apellido LIKE 'Barchuk'
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT emp.*
FROM empleado emp
INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro
WHERE dep.nombre_depto LIKE 'Contabilidad'
ORDER BY emp.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, apellido
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM empleado emp
INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro
WHERE dep.nombre_depto LIKE 'Ventas'
ORDER BY emp.salario DESC
LIMIT 1;