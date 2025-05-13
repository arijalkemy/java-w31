DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE `plan`(
	`id` int NOT NULL,
    `velocidad` float,
    `precio` float,
	`descuento`float,
    PRIMARY KEY (`id`)
);

CREATE TABLE `cliente` (
	`id` int NOT NULL,
	`dni` varchar(255),
    `nombre` varchar(255),
    `apellido` varchar(255),
    `fecha_nacimiento` date,
    `provincia` varchar(255),
    `ciudad` varchar(255),
    `plan_id` int NOT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`)
);

INSERT INTO `plan` VALUES (1, 100, 50, 10),(2, 200, 80, 20),(3, 500, 150, 50),(4, 800, 200, 100),(5, 1000, 300, 200);

INSERT INTO `cliente` VALUES
(1, '1234', 'Lionel', 'Messi', '1987-06-24', 'Rosario', 'Santa Fe', 5),
(2, '5678', 'Maria', 'Perez', '1990-05-20', 'Buenos Aires', 'Buenos Aires', 1),
(3, '9012', 'Juan', 'Gomez', '1985-11-01', 'Cordoba', 'Cordoba', 2),
(4, '3456', 'Ana', 'Rodriguez', '1992-03-15', 'Mendoza', 'Mendoza', 3),
(5, '7890', 'Carlos', 'Lopez', '1980-07-22', 'Salta', 'Salta', 4),
(6, '2109', 'Laura', 'Martinez', '1995-09-10', 'Rosario', 'Santa Fe', 5),
(7, '6543', 'Diego', 'Sanchez', '1988-01-30', 'La Plata', 'Buenos Aires', 1),
(8, '8765', 'Sofia', 'Diaz', '1993-06-05', 'Cordoba', 'Cordoba', 2),
(9, '4321', 'Fernando', 'Torres', '1982-12-18', 'San Miguel de Tucumán', 'Tucumán', 3),
(10, '0987', 'Valeria', 'Garcia', '1991-04-25', 'Mar del Plata', 'Buenos Aires', 4);

-- 1. Mostrar el nombre y apellido de todos los clientes
SELECT nombre, apellido FROM cliente;

-- 2. Mostrar cuantos clientes tienen contratado el plan 5
SELECT count(nombre) AS clientes_plan_5 FROM cliente WHERE plan_id = 5;

-- 3. Mostrar nombre y apellido de clientes de la ciudad de Buenos Aires
SELECT nombre, apellido FROM cliente WHERE ciudad = 'Buenos Aires';

-- 4. Mostrar el plan más barato
SELECT * FROM plan ORDER BY precio LIMIT 1;

-- 5. Mostrar el plan más caro
SELECT * FROM plan ORDER BY precio DESC LIMIT 1;

-- 6. Mostrar el plan más contratado por los clientes
SELECT plan_id, count(plan_id) FROM cliente GROUP BY plan_id;

-- 7. Mostrar el nombre, apellido y fecha de nacimiento de los clientes, del más mayor al más joven
SELECT nombre, apellido, fecha_nacimiento FROM cliente ORDER BY fecha_nacimiento;

-- 8. Mostrar nombre, apellido y ciudad de los clientes fuera de la ciudad de Buenos Aires
SELECT nombre, apellido, ciudad FROM cliente WHERE ciudad NOT LIKE 'Buenos Aires';

-- 9. Mostrar planes con 300 mbps o más
SELECT * FROM plan WHERE velocidad >= 300;

-- 10. Mostrar nombre, apellido y plan de clientes con a en su nombre
SELECT nombre, apellido, plan_id FROM cliente WHERE nombre LIKE '%a%';