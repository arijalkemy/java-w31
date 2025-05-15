/*Se requiere obtener las siguientes consultas:*/

/*1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

/*2. Visualizar los departamentos con más de cinco empleados.*/
SELECT d.nombre_depto, COUNT(e.cod_emp) AS cantidad_empleados
FROM departamento d
JOIN empleado e ON d.depto_nro = e.depto_nro
GROUP BY d.nombre_depto
HAVING COUNT(e.cod_emp) > 5;

/*3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (
	SELECT puesto
    FROM empleado
    WHERE nombre = 'Mito' AND apellido = 'Barchuk'
);

/*4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/
SELECT e.*
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

/*5. Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT nombre
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

/*6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SELECT e.*
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
AND e.salario = (
	SELECT MAX(salario)
    FROM empleado
    JOIN departamento ON empleado.depto_nro = departamento.depto_nro
    WHERE departamento.nombre_depto = 'Ventas'
);