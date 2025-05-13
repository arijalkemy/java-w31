-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT e.nombre, e.puesto, d.localidad
FROM empleado e JOIN departamento d 
ON e.depto_nro = d.depto_nro
WHERE e.puesto LIKE 'Vendedor';

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(*) as Empleados
FROM departamento d JOIN empleado e
ON d.depto_nro = e.depto_nro
GROUP BY d.nombre_depto, e.depto_nro
HAVING Empleados > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM departamento d JOIN empleado e
ON d.depto_nro = e.depto_nro
WHERE e.puesto LIKE (SELECT puesto FROM empleado WHERE nombre LIKE 'Mito' AND apellido LIKE 'Barchuk');

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT *
FROM departamento d JOIN empleado e
ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto LIKE 'Contabilidad'
ORDER BY e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleado
ORDER BY salario
LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM departamento d JOIN empleado e
ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto LIKE 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;