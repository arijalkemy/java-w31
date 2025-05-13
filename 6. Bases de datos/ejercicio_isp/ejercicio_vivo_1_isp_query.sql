SELECT * FROM Planes_Internet;
SELECT nombre, apellido FROM Clientes WHERE fecha_nacimiento > '1990-12-31';
SELECT * FROM Planes_Internet WHERE velocidad_mbps > 200;
SELECT provincia, COUNT(*) AS total_clientes FROM Clientes GROUP BY provincia;
SELECT dni, nombre, apellido FROM Clientes WHERE id_plan_contratado = 1;
SELECT dni, nombre, apellido, ciudad, provincia FROM Clientes WHERE ciudad = 'Rosario' AND provincia = 'Santa Fe';
SELECT dni, nombre, apellido FROM Clientes WHERE nombre LIKE 'A%';
SELECT dni, nombre, apellido FROM Clientes WHERE nombre LIKE 'A%';