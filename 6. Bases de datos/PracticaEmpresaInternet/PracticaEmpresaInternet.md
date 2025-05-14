# Practica Consultas (Empresa internet)
![der](https://i.postimg.cc/RCwk1NJ0/movies-db-diagram.png)

## _Consigna_

Una empresa proveedora de Internet necesita una base de datos para almacenar cada uno de sus clientes junto con el plan/pack que tiene contratado.

Mediante un análisis previo se conoce que se tiene que almacenar la siguiente información:

-   De los clientes se debe registrar: dni, nombre, apellido, fecha de nacimiento, provincia, ciudad.
-   En cuanto a los planes de internet: identificación del plan, velocidad ofrecida en megas, precio, descuento.

## _Ejercicio I_
Luego del planteo de los requerimientos de la empresa, se solicita modelar los mismos mediante un DER (Diagrama Entidad-Relación).

![der](https://i.postimg.cc/gk73wdjH/proveedora-de-internet.jpg)

## _Ejercicio II_
Una vez modelada y planteada la base de datos, responder a las siguientes preguntas:

**a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta**
**R/** La PK para la tabla de clientes según el enunciado es el dni

**b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.**
**R/** La PK para la tabla de planes sería id

**c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.**
**R/** Se identifica que la relación entre tablas es 1:1, leyendose de la siguiente manera; un cliente tiene un plan asimismo un plan tiene un cliente, la tabla (dominante) que tiene la FK es la tabla de clientes, esta FK en la tabla de clientes hace referencia la PK de la tabla planes

## _Ejercicio III_
Una vez realizado el planteo del diagrama y de haber respondido estas preguntas, utilizar PHPMyAdmin o MySQL Workbench para ejecutar lo siguiente:

**1.  Se solicita crear una nueva base de datos llamada “empresa_internet”.**
**R/** Para la creación de la base de datos empresa_internet se hace uso del siguiente SQL statement  `CREATE DATABASE empresa_internet;` posteriormente, se usa la bd (`USE empresa_internet;`) para garantizar que los scripts hechos hagan referencia a la recién creada database `"empresa_internet"`

**2.  Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.**
**R/** 
		registros clientes (10),
		`INSERT INTO cliente (dni, nombre, apellido, provincia, fecha_de_nacimiento, ciudad, id_plan) VALUES
(10000001, 'Juan',    'Pérez',     'Buenos Aires', '1990-01-15', 'La Plata',     1),
(10000002, 'Ana',     'García',    'Córdoba',      '1985-02-20', 'Córdoba',      2),
(10000003, 'Luis',    'Fernández', 'Santa Fe',     '1992-03-30', 'Rosario',      3),
(10000004, 'Laura',   'Martínez',  'Mendoza',      '1988-04-10', 'Mendoza',      4),
(10000005, 'María',   'López',     'Tucumán',      '1995-05-24', 'San Miguel',   5),
(10000006, 'Pedro',   'Suárez',    'Buenos Aires', '1991-06-16', 'Mar del Plata',1),
(10000007, 'Lucía',   'Sánchez',   'Mendoza',      '1980-07-17', 'Godoy Cruz',   2),
(10000008, 'Hugo',    'Díaz',      'Santa Fe',     '1987-08-22', 'Santa Fe',     3),
(10000009, 'Camila',  'Torres',    'Córdoba',      '1993-09-13', 'Villa María',  4),
(10000010, 'Sofía',   'Romero',    'Buenos Aires', '1994-10-11', 'Lanús',        5);`

Registros planes (5)

`INSERT INTO plan (id, velocidad, descuento, precio) VALUES
(1, 50, 10, 3000),
(2, 100, 15, 5000),
(3, 200, 20, 8000),
(4, 300, 25, 12000),
(5, 500, 30, 20000);`
		
**3.  Realizar las asociaciones/relaciones correspondientes entre estos registros.**

Se realiza una relación uno a uno tal como se evidencia en la siguiente imagen

![der](https://i.postimg.cc/cJcRLbzR/empresa-internet.png)

**4. Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.**

 SQL para Consultas en la Base de Datos  `empresa_internet`

## Consultas

## Ver todos los clientes

> Mostrar toda la información registrada en la tabla `cliente`.

`SELECT * FROM cliente;` 

----------

## Clientes de Buenos Aires

> Mostrar los nombres y apellidos de los clientes que pertenecen a la provincia 'Buenos Aires'.

`SELECT nombre, apellido
FROM cliente
WHERE provincia = 'Buenos Aires';` 

----------

## Clientes con planes de alta velocidad

> Listar los nombres de los clientes y la ciudad en la que viven, cuyo plan sea de velocidad igual o mayor a 200.

`SELECT c.nombre, c.ciudad
FROM cliente c
JOIN plan p ON c.id_plan = p.id
WHERE p.velocidad >= 200;` 

----------

## Precio mensual por cliente

> Mostrar el nombre, apellido y el precio mensual que paga cada cliente por su plan.

`SELECT c.nombre, c.apellido, p.precio
FROM cliente c
JOIN plan p ON c.id_plan = p.id;` 

----------

## Clientes por provincia

> Contar cuántos clientes hay por cada provincia.

`SELECT provincia, COUNT(*) as cantidad_clientes
FROM cliente
GROUP BY provincia;` 

----------

## Clientes con mucho descuento

> Listar los clientes que tienen un descuento del 20% o más en su plan.

`SELECT c.nombre, c.apellido, p.descuento
FROM cliente c
JOIN plan p ON c.id_plan = p.id
WHERE p.descuento >= 20;` 

----------

## Cliente más joven

> Encontrar el cliente más joven (el de la fecha de nacimiento más reciente).

`SELECT nombre, apellido, fecha_de_nacimiento
FROM cliente
ORDER BY fecha_de_nacimiento DESC
LIMIT 1;` 

----------

## Clientes según velocidad

> Listar los nombres de los clientes y la velocidad de su plan, ordenados de mayor a menor velocidad.

`SELECT c.nombre, c.apellido, p.velocidad
FROM cliente c
JOIN plan p ON c.id_plan = p.id
ORDER BY p.velocidad DESC;` 

----------

## Clientes nacidos antes de 1990

> Mostrar el nombre y apellido de los clientes que nacieron antes de 1990.


`SELECT nombre, apellido
FROM cliente
WHERE fecha_de_nacimiento < '1990-01-01';` 

----------

## Cantidad de clientes por velocidad

> Mostrar la cantidad de clientes para cada velocidad de plan.

`SELECT p.velocidad, COUNT(*) AS cantidad_clientes
FROM cliente c
JOIN plan p ON c.id_plan = p.id
GROUP BY p.velocidad;`


