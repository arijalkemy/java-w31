DROP DATABASE IF EXISTS empresa;
CREATE DATABASE empresa;
USE empresa;
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE empleado (cod_emp varchar(10)  NOT NULL PRIMARY KEY,
nombre varchar(100) NOT NULL,
apellido varchar(100) NOT NULL,
puesto varchar(50) NOT NULL,
fecha_alta date NOT NULL,
salario int(50) NOT NULL,
comision int(50) DEFAULT 0,
depto_nro varchar(10) NOT NULL );


DROP TABLE IF EXISTS `departamento`;
CREATE TABLE departamento (depto_nro varchar(10)  NOT NULL PRIMARY KEY,
nombre_depto varchar(100) NOT NULL,
localidad varchar(100) NOT NULL);

ALTER TABLE `empleado` ADD FOREIGN KEY (`depto_nro`) REFERENCES `departamento` (`depto_nro`);

-- Insertar datos en la tabla departamento
INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- Insertar datos en la tabla empleado
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

SELECT e.nombre, e.puesto, d.localidad 
FROM empleado e 
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

SELECT COUNT(*) AS num_empleados, e.depto_nro 
FROM empleado e 
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
GROUP BY e.depto_nro
HAVING num_empleados >5;

SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e 
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE e.puesto = "presidente";

SELECT e.*
FROM empleado e 
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.nombre;


SELECT nombre, salario
FROM empleado
WHERE salario IN (SELECT MIN(salario) FROM empleado );

SELECT e.nombre, e.salario
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.salario IN (
    SELECT MAX(salario)
    FROM empleado
    INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
    WHERE departamento.nombre_depto = 'Ventas'
);
