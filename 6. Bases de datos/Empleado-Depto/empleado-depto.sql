CREATE DATABASE deptos_empleados;
USE deptos_empleados;

CREATE TABLE `empleado` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(20),
  `apellido` varchar(20),
  `puesto` varchar(20),
  `fecha_alta` date,
  `salario` decimal,
  `comision` integer,
  `depto_nro` integer
);

CREATE TABLE `departamento` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `nombre_depto` varchar(50),
  `localidad` varchar(20)
);

ALTER TABLE `empleado` ADD FOREIGN KEY (`depto_nro`) REFERENCES `departamento` (`id`);

INSERT INTO `departamento` (`nombre_depto`, `localidad`) VALUES
('Software', 'Los Tigres'),
('Sistemas', 'Guadalupe'),
('Contabilidad', 'La Roca'),
('Ventas', 'Plata');

INSERT INTO `empleado`(`nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES
('César', 'Piñero', 'Vendedor', '20180512', 80000.0, 15000, 4),
('Yosep', 'Kowaleski', 'Analista', '20150713', 140000.0, 0, 2),
('Mariela', 'Barrios', 'Director', '20140605', 185000.0, 0, 3),
('Jonathan', 'Aguilera', 'Vendedor', '20150603', 85000.0, 10000, 4),
('Daniel', 'Brezezicki', 'Vendedor', '20180303', 83000.0, 10000, 4),
('Mito', 'Barchuk', 'Presidente', '20140605', 190000.0, 0, 3),
('Emilio', 'Galarza', 'Desarollador', '20140802', 60000.0, 0, 1);

/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e JOIN departamento d
ON e.depto_nro = d.id;
/*Visualizar los departamentos con más de cinco empleados.*/
SELECT d.nombre_depto, COUNT(*) AS cantidad_empleados
FROM departamento d
JOIN empleado e ON d.id = e.depto_nro
GROUP BY d.nombre_depto
HAVING cantidad_empleados > 5;
/*Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e JOIN departamento d
ON e.depto_nro = d.id
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre LIKE '%Mito Barchuk%');
/*Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/
SELECT e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, d.nombre_depto
FROM empleado e JOIN departamento d
ON e.depto_nro = d.id
WHERE d.nombre_depto LIKE '%Contabilidad%'
ORDER BY e.nombre;
/*Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT nombre, apellido
FROM empleado
ORDER BY salario ASC
LIMIT 1;
/*Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SELECT e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, d.nombre_depto
FROM empleado e JOIN departamento d
ON e.depto_nro = d.id
WHERE d.nombre_depto LIKE '%Ventas%'
ORDER BY salario DESC
LIMIT 1;