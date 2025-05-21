/*
Ejercicio 2
a) La pk de para la tabla clientes es id
b) La pk de la tabla de planes es id
c) La relacion entre las tablas es de 1 a muchos(n), siendo que un plan lo pueden tener muchos clientes. La fk deberia estar en la tabla de clientes
y hace referencia al id del plan.
*/

/*
Ejercicio 3
*/
INSERT INTO plan (id, velocidad, precio, descuento) VALUES
(1, 50, 20, 5.0),
(2, 100, 35, 10.0),
(3, 200, 50, 15.0),
(4, 300, 65, 20.0),
(5, 500, 80, 25.0);

INSERT INTO cliente (id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, plan_id) VALUES
(1, 12345678, 'Juan', 'Pérez', '1980-01-01', 'ProvinciaA', 'CiudadX', 1),
(2, 23456789, 'Ana', 'Gómez', '1992-05-15', 'ProvinciaB', 'CiudadY', 2),
(3, 34567890, 'María', 'López', '1985-07-23', 'ProvinciaA', 'CiudadZ', 3),
(4, 45678901, 'Carlos', 'Fernández', '1975-10-30', 'ProvinciaC', 'CiudadX', 1),
(5, 56789012, 'Lucía', 'Martínez', '1999-04-10', 'ProvinciaD', 'CiudadY', 2),
(6, 67890123, 'Pedro', 'Sánchez', '1988-11-12', 'ProvinciaA', 'CiudadZ', 3),
(7, 78901234, 'Sofía', 'Díaz', '1990-09-20', 'ProvinciaB', 'CiudadX', 4),
(8, 89012345, 'Miguel', 'Ramírez', '1983-12-25', 'ProvinciaC', 'CiudadY', 5),
(9, 90123456, 'Laura', 'Torres', '1978-02-05', 'ProvinciaD', 'CiudadZ', 1),
(10, 98765432, 'José', 'Vega', '1995-06-18', 'ProvinciaA', 'CiudadX', 2);

/*
Ejercicio 4
*/

SELECT id, apellido FROM cliente WHERE fecha_nacimiento BETWEEN "1980-01-01" AND "1990-12-31";

DELETE FROM cliente WHERE id = 2;

SELECT * FROM cliente WHERE provincia = 'ProvinciaA';

SELECT c.nombre, c.apellido
FROM cliente c
JOIN plan p ON c.plan_id = p.id
WHERE p.velocidad > 100;

SELECT ciudad, COUNT(*) AS total_clientes
FROM cliente
GROUP BY ciudad;

SELECT * FROM plan ORDER BY precio DESC LIMIT 1;

SELECT AVG(precio) AS promedio_precio FROM plan;

SELECT * FROM cliente WHERE nombre LIKE 'M%';

SELECT p.*
FROM plan p
JOIN cliente c ON c.plan_id = p.id
WHERE c.dni = 12345678;

SELECT c.nombre, c.apellido, p.id AS plan_id, p.velocidad
FROM cliente c
JOIN plan p ON c.plan_id = p.id;


