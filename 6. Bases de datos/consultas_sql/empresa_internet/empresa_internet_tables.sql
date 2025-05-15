CREATE TABLE `clientes` (
  `id_cliente` integer AUTO_INCREMENT PRIMARY KEY,
  `dni` varchar(255),
  `nombre` varchar(255),
  `apellido` varchar(255),
  `fecha_nac` varchar(255),
  `provincia` varchar(255),
  `ciudad` varchar(255),
  `id_plan` integer NOT NULL
);

CREATE TABLE `planes_internet` (
  `id_plan` integer AUTO_INCREMENT PRIMARY KEY,
  `identificador_plan` integer,
  `velocidad_megas` integer,
  `precio` double,
  `descuento` integer
);

ALTER TABLE `clientes` ADD FOREIGN KEY (`id_plan`) REFERENCES `planes_internet` (`id_plan`);

INSERT INTO planes_internet (identificador_plan, velocidad_megas, precio, descuento) VALUES
(1, 25,   1500, 10),
(2, 50,   2000, 15),
(3, 100,  3000, 20),
(4, 200,  5000, 10),
(5, 500,  8000, 25);

INSERT INTO clientes (dni, nombre, apellido, fecha_nac, provincia, ciudad, id_plan) VALUES
('30000001', 'Juan',    'Pérez',      '1990-05-10', 'Buenos Aires', 'La Plata',      1),
('30000002', 'María',   'Gómez',      '1987-09-12', 'Buenos Aires', 'Mar del Plata', 2),
('30000003', 'Luis',    'Fernández',  '1995-01-20', 'Córdoba',      'Córdoba',       3),
('30000004', 'Ana',     'Moreno',     '2000-03-17', 'Santa Fe',     'Rosario',       4),
('30000005', 'Sofía',   'López',      '1996-10-03', 'Mendoza',      'Mendoza',       5),
('30000006', 'Pedro',   'Ruiz',       '1985-02-07', 'Buenos Aires', 'Bahía Blanca',  1),
('30000007', 'Lucía',   'Martínez',   '1992-04-23', 'Salta',        'Salta',         2),
('30000008', 'Carlos',  'Torres',     '1998-07-30', 'Tucumán',      'San Miguel',    3),
('30000009', 'Paula',   'Ramos',      '1980-12-15', 'Entre Ríos',   'Paraná',        4),
('30000010', 'Diego',   'Sánchez',    '1993-11-11', 'Chaco',        'Resistencia',   5);

/*Consultas a la base*/
/*1.Listar todos los clientes registrados en la empresa*/
select nombre, apellido from clientes;
/*2.Mostrar todos los planes de internet disponibles*/
select id_plan,velocidad_megas from planes_internet;
/*3.Obtener el nombre y apellido de los clientes junto con los datos del plan de internet que tienen contratado*/
select c.nombre,c.apellido,p.id_plan,p.velocidad_megas from clientes c JOIN planes_internet p ON  c.id_plan=p.id_plan;
/*4.Listar los clientes que tienen un plan de internet con descuento igual o superior al 20%*/
select c.nombre,c.apellido from clientes c JOIN planes_internet p ON c.id_plan=p.id_plan where p.descuento >=20;
/*5.Calcular la cantidad de clientes que hay en cada provincia*/
select provincia,COUNT(id_cliente) from clientes GROUP BY provincia;
/*6.Mostrar los planes de internet cuyo precio supere los 100 megas*/
select id_plan from planes_internet where velocidad_megas>100;
/*7.Listar los clientes que residen en una provincia específica*/
select nombre, apellido from clientes where provincia = "Cordoba";
/*8.Contar la cantidad de clientes asociados a cada plan de internet*/
select id_plan, COUNT(id_cliente) from clientes GROUP BY id_plan;
/*9.Listar todos los clientes que nacieron entre 1990 y 1996*/
select nombre, apellido from clientes where YEAR(fecha_nac) BETWEEN 1990 and 1996;
/*10.Obtener todos los datos del cliente que tenga un DNI 30000002*/
select * from clientes where dni="30000002";

