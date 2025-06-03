show databases;
use empresa;
show tables;

#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.apellido, e.puesto, d.localidad
from empleado e join departamento d on e.depto_nro = d.depto_nro
where e.puesto = 'Vendedor';

#Visualizar los departamentos con más de cinco empleados.
select d.nombre_depto, count(e.cod_emp)
from empleado e join departamento d on e.depto_nro = d.depto_nro
group by d.nombre_depto
having count(e.cod_emp) > 2;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
where e.puesto = (select puesto from empleado where nombre = 'Mito' AND apellido = 'Barchuk');

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select *
from empleado
where depto_nro = (select depto_nro from departamento where nombre_depto = 'COntabilidad')
order by nombre;

#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM empleado
WHERE salario = (
    SELECT MAX(salario) 
    FROM empleado 
    WHERE depto_nro = (SELECT depto_nro FROM departamento WHERE nombre_depto = 'Ventas')
);

