Una empresa proveedora de Internet necesita una base de datos para almacenar cada uno de sus clientes junto con el plan/pack que tiene contratado.

Mediante un análisis previo se conoce que se tiene que almacenar la siguiente información:

De los clientes se debe registrar: dni, nombre, apellido, fecha de nacimiento, provincia, ciudad.
En cuanto a los planes de internet: identificación del plan, velocidad ofrecida en megas, precio, descuento.


Ejericio 1:

Entidades

Cliente:
* dni
* nombre
* apellido
* fecha de nacimiento
* provincia
* ciudad
* id plan

Plan:
* id
* velocidad ofrecida en megas
* precio
* descuento

Ejercicio 1:

a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
Definimos como primary key de la entidad cliente el dni, porque es un identificador único de cada cliente.

b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
Definimos como primary key de la entidad Planes de internet su id, porque es un identificador único de cada plan.

c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key?
Justificar respuesta.

La relación entre tablas es de uno a uno, un cliente puede tener un plan.
En la tabla Cliente debería haber Foreign Key.
Por lo tanto la tabla Cliente tiene un campo que se llama id plan, la cual es FK de la tabla Plan.

CREATE DATABASE empresa_internet;

USE empresa_internet;

CREATE TABLE plan_de_internet(
        id VARCHAR(6) PRIMARY KEY,
        megas INTEGER,
        precio DECIMAL(10,2),
        descuento DECIMAL(10,2)
);

CREATE TABLE cliente (
        dni VARCHAR(20) PRIMARY KEY,
        nombre VARCHAR(100),  
        apellido VARCHAR(100),
        fecha_de_nacimiento DATETIME,
        provincia VARCHAR(100),
        ciudad VARCHAR(100),
        id_plan VARCHAR(6),
        FOREIGN KEY (id_plan) REFERENCES plan_de_internet(id)
);

INSERT INTO plan_de_internet (id, megas, precio, descuento) VALUES
('PLAN01', 50, 1500.00, 0.00),
('PLAN02', 100, 2500.00, 5.00),
('PLAN03', 300, 4500.00, 10.00),
('PLAN04', 500, 6000.00, 15.00),
('PLAN05', 1000, 9500.00, 20.00);


INSERT INTO cliente (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad, id_plan) VALUES
('12345678A', 'Juan', 'Pérez', '1985-04-12 00:00:00', 'Buenos Aires', 'La Plata', 'PLAN01'),
('23456789B', 'María', 'Gómez', '1990-07-23 00:00:00', 'Córdoba', 'Villa María', 'PLAN02'),
('34567890C', 'Carlos', 'Ramírez', '1982-11-05 00:00:00', 'Mendoza', 'Godoy Cruz', 'PLAN03'),
('45678901D', 'Lucía', 'Fernández', '1995-02-18 00:00:00', 'Santa Fe', 'Rosario', 'PLAN01'),
('56789012E', 'Diego', 'Martínez', '1988-09-30 00:00:00', 'Córdoba', 'Capital', 'PLAN02'),
('67890123F', 'Ana', 'Torres', '1993-06-10 00:00:00', 'Salta', 'Salta', 'PLAN03'),
('78901234G', 'Sofía', 'Díaz', '2000-01-22 00:00:00', 'Neuquén', 'Neuquén', 'PLAN01'),
('89012345H', 'Martín', 'López', '1998-12-15 00:00:00', 'Chaco', 'Resistencia', 'PLAN02'),
('90123456I', 'Juan', 'Sánchez', '1986-03-07 00:00:00', 'Corrientes', 'Corrientes', 'PLAN03'),
('01234567J', 'Federico', 'Alvarez', '1992-08-19 00:00:00', 'Entre Ríos', 'Paraná', 'PLAN01');

Ejercicio 4

1 - Cuantos clientes con nombre Juan hay?
SELECT count(*) FROM cliente WHERE nombre LIKE "%Juan%";

2 - Cuantos clientes hay de la década de los 80?
SELECT count(*) FROM cliente WHERE "1980-01-01" < fecha_de_nacimiento AND fecha_de_nacimiento < "1990-01-01";

3 - Cuantos planes hay de cada uno?
SELECT id_plan, count(*)
FROM cliente
GROUP BY id_plan;

4 - Cual es el plan más caro?
SELECT * FROM plan_de_internet ORDER BY precio DESC LIMIT 1;

5 - Podes mostrar el nombre y apellido con la cantidad de megas?
SELECT cl.nombre, cl.apellido, pdi.id, pdi.megas
FROM cliente as cl
LEFT JOIN plan_de_internet as pdi ON pdi.id = cl.id_plan;

6 - En donde vive Diego Martinéz?
SELECT ciudad, provincia FROM cliente WHERE nombre = "Diego" AND apellido = "Martínez";

7 - Promedio de megas del plan de internet?
SELECT ROUND(AVG(megas),0) as "Promedio de Megas" FROM plan_de_internet;

8 - Cuanto recauda cada plan?
SELECT pdi.id as "Plan", SUM(precio)
FROM cliente as cl
LEFT JOIN plan_de_internet as pdi ON pdi.id = cl.id_plan
GROUP BY pdi.id;

9 - Cual es el plan que más usuarios tiene?
SELECT pdi.id, count(*) as "usuarios totales"
FROM cliente as cl
LEFT JOIN plan_de_internet as pdi ON pdi.id = cl.id_plan
GROUP BY pdi.id
ORDER BY "usuarios totales" DESC
LIMIT 1;

10 - Mostrar los clientes que viven en Córdoba.
SELECT *
FROM cliente
WHERE provincia = "Córdoba";