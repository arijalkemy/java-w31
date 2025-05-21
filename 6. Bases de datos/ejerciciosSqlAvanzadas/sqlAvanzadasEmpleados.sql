/*1.*/
select depto.nombre_depto, empleado.puesto, depto.localidad
from depto inner join empleado on empleado.depto_nro = depto.depto_nro;

/*2.*/
select depto.nombre_depto, count(*) as cantidad_empleados
from depto inner join empleado on empleado.depto_nro = depto.depto_nro
group by nombre_depto
having cantidad_empleados > 5;

/*3.*/
select empleado.nombre, empleado.salario, depto.depto_nro
from empleado inner join depto on depto.depto_nro = empleado.depto_nro
where empleado.puesto = (select puesto from empleado where nombre = "Mito" and apellido = "Barchuk")
and apellido != "Barchuk";

/*4.*/
select empleado.* 
from empleado inner join depto on depto.depto_nro = empleado.depto_nro
where depto.nombre_depto = "Contabilidad"
order by empleado.nombre;

/*5.*/
select nombre, salario
from empleado
where salario = (select min(salario) from empleado);

/*6.*/
select empleado.nombre, empleado.salario as salario
from empleado inner join depto on depto.depto_nro = empleado.depto_nro
where depto.nombre_depto = "Ventas" and empleado.salario = (
      select MAX(salario) 
      from empleado
      inner join depto on depto.depto_nro = empleado.depto_nro
      where depto.nombre_depto = 'Ventas'
  );
