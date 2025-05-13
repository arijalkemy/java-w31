CREATE database empresa_internet;
USE empresa_internet;

CREATE TABLE `cliente` (
  `id_cliente` integer PRIMARY KEY AUTO_INCREMENT,
  `dni` varchar(10),
  `nombre` varchar(20),
  `apellido` varchar(20),
  `fecha_nacimiento` date,
  `provincia` varchar(20),
  `ciudad` varchar(20),
  `plan_id` integer
);

CREATE TABLE `plan` (
  `plan_id` integer PRIMARY KEY AUTO_INCREMENT,
  `velocidad_en_megas` integer,
  `precio` decimal,
  `descuento` decimal
);

ALTER TABLE `cliente` ADD FOREIGN KEY (`plan_id`) REFERENCES `plan` (`plan_id`);

/* 
a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
La primary key de la tabla clientes es id_cliente ya que es el identificador único. No puede ser dni porque 
es posible que haya duplicados.

b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
La primary key de la tabla plan es plan_id ya que es su identificador único.

c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? 
¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.
La relacion entre tablas es que un cliente tiene un plan, pero un plan tiene muchos clientes.
La foreign key está en la parte N de la relación, en este caso en clientes.
El campo plan_id hace referencia al id_plan de la tabla Plan.
*/

INSERT INTO `plan` (`velocidad_en_megas`, `precio`, `descuento`) VALUES
(50, 2500.00, 0.00),
(100, 3500.00, 5.00),
(300, 5000.00, 10.00),
(500, 6500.00, 15.00),
(1000, 9000.00, 20.00);

INSERT INTO `cliente` (`dni`, `nombre`, `apellido`, `fecha_nacimiento`, `provincia`, `ciudad`, `plan_id`) VALUES
('12345678A', 'Ana', 'Pérez', '1990-04-12', 'Buenos Aires', 'La Plata', 1),
('23456789B', 'Juan', 'Gómez', '1985-07-20', 'Córdoba', 'Córdoba', 2),
('34567890C', 'Lucía', 'Martínez', '1995-03-10', 'Santa Fe', 'Rosario', 3),
('45678901D', 'Carlos', 'López', '1992-11-05', 'Mendoza', 'Godoy Cruz', 1),
('56789012E', 'María', 'Rodríguez', '1988-01-22', 'Salta', 'Salta', 4),
('67890123F', 'Diego', 'Fernández', '1993-08-14', 'Tucumán', 'San Miguel', 5),
('78901234G', 'Laura', 'Sánchez', '2000-12-30', 'Buenos Aires', 'Mar del Plata', 2),
('89012345H', 'Sofía', 'García', '1998-06-18', 'Chaco', 'Resistencia', 3),
('90123456I', 'Pedro', 'Torres', '1991-09-07', 'Neuquén', 'Neuquén', 5),
('01234567J', 'Valentina', 'Molina', '1994-02-25', 'Entre Ríos', 'Paraná', 4);

/*Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.*/
/* 1 - Listar todos los campos de planes */
SELECT * FROM plan;
/* 2 - Listar los campos de planes cuya velocidad es mayor o igual a 300 */
SELECT * FROM plan
WHERE velocidad_en_megas >= 300;
/* 3 - Listar los campos de planes cuyo precio es menor a 5000 */
SELECT * FROM plan 
WHERE precio < 5000;
/* 4 - Listar los campos de planes cuyo descuento es mayor a 5, ordenados por precio de forma ASC */
SELECT * FROM plan 
WHERE descuento > 5.0
ORDER BY precio ASC;
/* 5 - Listar los campos de planes cuyo descuento es mayor a 10 y 
su velocidad es mayor a 100. Ordenar los descuentos de forma descendente */
SELECT * FROM plan 
WHERE descuento > 10.0 AND velocidad_en_megas > 100
ORDER BY descuento DESC;
/* 6 - Listar los nombres de los clientes que tengan nombre que hayan
 nacido entre 1998 y 2000 */
 SELECT nombre FROM cliente
 WHERE fecha_nacimiento BETWEEN '19980101' AND '20001231';
/* 7 - Listar los campos de los clientes que viven en Buenos Aires */
SELECT * FROM cliente
WHERE provincia LIKE 'Buenos Aires%';
/* 8 - Listar los campos de los clientes que tienen el plan 3 */
SELECT * FROM cliente
WHERE plan_id = 3;
/* 9 - Listar dni, nombre y apellido de los clientes que tienen plan 3, ordenados de manera ascendente por el nombre */
SELECT dni, nombre, apellido FROM cliente
WHERE plan_id = 3
ORDER BY nombre ASC;
/* 10 - Listar los primeros 5 clientes de la lista y ordenar el plan de manera ascendente*/
SELECT * FROM cliente
ORDER BY plan_id ASC
LIMIT 5;