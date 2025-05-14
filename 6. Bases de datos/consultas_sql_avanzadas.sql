-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT em.nombre, em.puesto, de.localidad 
FROM empleado em INNER JOIN departamento de
ON em.depto_nro = de.depto_nro
WHERE em.puesto LIKE 'Vendedor';

-- Visualizar los departamentos con más de cinco empleados.
SELECT de.nombre_depto, COUNT(em.cod_emp) AS cantidad_empleados
FROM empleado em INNER JOIN departamento de
ON em.depto_nro = de.depto_nro
GROUP BY de.nombre_depto HAVING cantidad_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre, em.salario, de.nombre_depto
FROM empleado em INNER JOIN departamento de
ON em.depto_nro = de.depto_nro
WHERE em.puesto LIKE (SELECT em.puesto FROM empleado
WHERE em.nombre LIKE 'Mito' AND em.apellido LIKE 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT em.*, de.nombre_depto
FROM departamento de INNER JOIN empleado em 
ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto LIKE 'Contabilidad'
ORDER BY em.nombre ASC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT em.cod_emp, em.nombre, em.apellido, em.puesto, em.fecha_alta, em.salario, em.comision, em.depto_nro 
FROM empleado em  INNER JOIN departamento de 
ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto LIKE 'Ventas'
ORDER BY em.salario DESC
LIMIT 1;