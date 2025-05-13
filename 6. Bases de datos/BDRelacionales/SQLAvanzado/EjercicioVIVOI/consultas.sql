-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT
	e.nombre,
    e.apellido,
    e.puesto,
    d.localidad
FROM empleado e
INNER JOIN departamento d ON e.dpto_nro = d.dpto_nro
WHERE e.puesto = 'vendedor';

-- Visualizar los departamentos con más de cinco empleados.
SELECT
    d.dpto_nro,
    d.nombre,
    d.localidad,
    COUNT(e.cod_emp) AS total_empleados
FROM departamento d
INNER JOIN empleado e ON e.dpto_nro = d.dpto_nro
GROUP BY d.dpto_nro, d.nombre, d.localidad
HAVING COUNT(e.cod_emp) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT
    e.nombre,
    e.apellido,
    e.salario,
    d.nombre AS 'Departamento'
FROM empleado e
INNER JOIN departamento d ON e.dpto_nro = d.dpto_nro
WHERE e.puesto = (
    SELECT e2.puesto
    FROM empleado e2
    WHERE e2.nombre = 'Mito'
      AND e2.apellido = 'Barchuk'
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleado e
INNER JOIN departamento d ON e.dpto_nro = d.dpto_nro
WHERE d.nombre_dpto = 'Contabilidad'
ORDER BY e.nombre ASC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT
	e.nombre,
    e.apellido
FROM empleado e
WHERE e.salario = (
	SELECT MIN(e2.salario)
    FROM empleado e2
);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT
    e.*
FROM empleado e
INNER JOIN departamento d ON e.dpto_nro = d.dpto_nro
WHERE d.nombre_dpto = 'Ventas'
  AND e.salario = (
      SELECT MAX(e2.salario)
      FROM empleado e2
      INNER JOIN departamento d2 ON e2.dpto_nro = d2.dpto_nro
      WHERE d2.nombre_dpto = 'Ventas'
  );
