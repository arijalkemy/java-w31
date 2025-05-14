-- Insertar planes
INSERT INTO planes (velocidad_megas, precio, descuento)
VALUES 
(100, 1999.99, 10.00),
(300, 2999.99, 15.00),
(500, 3999.99, 20.00),
(1000, 4999.99, 25.00),
(150, 2299.99, 5.00);

-- Verficiar los planes
SELECT * FROM PLAN;

-- Insertar un clientes
INSERT INTO empresa_internet.cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, Plan_idPlan)
VALUES  
('12345678', 'Ana', 'Gómez', '1990-06-15', 'Buenos Aires', 'La Plata', 1),
('23456789', 'Luis', 'Martínez', '1985-03-22', 'Córdoba', 'Córdoba Capital', 2),
('34567890', 'María', 'López', '1992-07-10', 'Santa Fe', 'Rosario', 3),
('45678901', 'Carlos', 'Pérez', '1980-01-30', 'Mendoza', 'Mendoza Capital', 4),
('56789012', 'Lucía', 'Fernández', '1995-09-05', 'Tucumán', 'San Miguel de Tucumán', 1),
('67890123', 'Diego', 'Ramírez', '1988-12-12', 'Buenos Aires', 'Mar del Plata', 2),
('78901234', 'Sofía', 'Torres', '1993-11-01', 'Salta', 'Salta Capital', 5),
('89012345', 'Mateo', 'Sánchez', '1991-02-17', 'Chaco', 'Resistencia', 3),
('90123456', 'Camila', 'Herrera', '1996-06-25', 'Entre Ríos', 'Paraná', 4),
('01234567', 'Julián', 'Domínguez', '1983-08-18', 'Neuquén', 'Neuquén Capital', 5);

-- Verificar Clientes
SELECT * FROM Cliente;

/* Consulta 1 
Traer los clientes que tienen contratado el producto número 1*/
SELECT c.dni, c.nombre, c.apellido, c.fecha_nacimiento, c.provincia, c.ciudad FROM CLIENTE AS C
WHERE c.Plan_idPlan = 1;

/* Consulta 2
Traer todos los clientes cuya fecha de nacimiento esté entre 1990 y 1992 y que sean de Buenos Aires */
SELECT c.dni, c.nombre, c.apellido, c.fecha_nacimiento, c.provincia, c.ciudad FROM CLIENTE AS C
WHERE c.fecha_nacimiento BETWEEN '1990-01-01' AND '1992-12-31' AND c.provincia LIKE '%Buenos Aires%';

/* Consulta 3
Traer todos los planes cuyo descuento esté entre 15.00 y 20.00 */
SELECT p.idPlan, p.velocidad_plan, p.precio, p.descuento FROM PLAN AS P
WHERE p.descuento >= 15.00 AND P.descuento <= 20.00;

/* Consulta 4
Traer todos los clientes que contrataron los planes 1,3 y 5 y que hayan nacido despues del año 1992 */
SELECT c.dni, c.nombre, c.apellido, c.fecha_nacimiento, c.provincia, c.ciudad FROM CLIENTE AS C 
WHERE c.Plan_idPlan in (1,3,5) AND c.fecha_nacimiento > '1992-12-31';

/* Consulta 5 
 Traer todos los clientes cuya ciudad termine en Capital */
SELECT c.dni, c.nombre, c.apellido, c.fecha_nacimiento, c.provincia, c.ciudad FROM CLIENTE AS C 
WHERE c.ciudad LIKE '%Capital';

/* Consulta 6
Traer idPlan, precio y descuento de todos los planes */
SELECT p.idPlan, p.precio, p.descuento FROM PLAN AS P;

/* Consulta 7
Traer todos los planes que tenga una velocidad en megas entre 100 y 500 y que tengan descuento entre 10.00 y 20.00 */
SELECT p.idPlan, p.velocidad_plan, p.precio, p.descuento FROM PLAN AS P
WHERE p.velocidad_plan BETWEEN 100 AND 500 AND p.descuento BETWEEN 10.00 AND 20.00;

/* Consulta 8
Traer el nombre, el apellido y la fecha de nacimiento de los clientes ordenamos por la fecha de nacimiento ascendente */
SELECT c.dni, c.nombre, c.apellido, c.fecha_nacimiento FROM CLIENTE AS C 
ORDER BY c.fecha_nacimiento ASC;

/* Consulta 9 
Traer todos los planes ordenados descendentemente por precio */
SELECT p.idPlan, p.velocidad_plan, p.precio, p.descuento FROM PLAN AS P
ORDER BY p.precio DESC;

/* Consulta 10 
Traer todos los clientes ordenados asc por el plan contratado */
SELECT c.dni, c.nombre, c.apellido, c.fecha_nacimiento, c.provincia, c.ciudad, c.Plan_idPlan FROM CLIENTE AS C
ORDER BY c.Plan_idPlan ASC;
