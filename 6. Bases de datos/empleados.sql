# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad
from empleado e
join departamento d on e.depto_nro = e.depto_nro
where e.puesto = "Vendedor";

# Visualizar los departamentos con más de cinco empleados.
select d.*
from departamento d
join empleado e on e.depto_nro = d.depto_nro
group by d.depto_nro
having count(*) > 5;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, e.depto_nro
from empleado e
where e.puesto = (select e2.puesto from empleado e2 where e2.nombre = "Mito" and e2.apellido = "Barchuk" limit 1);

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select e.*
from empleado e
join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto like "%contabilidad%"
order by e.nombre desc;

# Mostrar el nombre del empleado que tiene el salario más bajo.
select *
from empleado
order by salario asc
limit 1;

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.*
from empleado e
join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto like "%ventas%"
order by salario desc
limit 1;
