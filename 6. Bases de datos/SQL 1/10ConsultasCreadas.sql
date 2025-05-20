-- CONSULTA 1 clientes de Buenos Aires
-- SELECT * FROM client WHERE city = "Buenos Aires"

-- CONSULTA 2 plan mas caro
-- SELECT * FROM plan ORDER BY price DESC LIMIT 1

-- CONSULTA 3 clientes con DNI arrancando por 8
-- SELECT * FROM client WHERE document LIKE "8%"

-- CONSULTA 4 clientes nacidos antes de 1990
-- SELECT * FROM client WHERE birth_date <= "1989-12-31"

-- CONSULTA 5 planes de mas de 150 de velocidad ordenados por velocidad descendiente
-- SELECT * FROM plan WHERE speed > 150 ORDER BY speed DESC

-- CONSULTA 6 planes de mas de 150 de velocidad y precio menor a 80
-- SELECT * FROM plan WHERE speed > 150 AND price < 80

-- CONSULTA 7 clientes con nombres que empiecen con J o M
-- SELECT * FROM client WHERE (name LIKE "J%" OR name LIKE "M%")

-- CONSULTA 8 todas las provincias de las cuales hay clientes
-- SELECT DISTINCT province FROM client

-- CONSULTA 9 nombre completo de clientes con apellido terminado en EZ
-- SELECT name, last_name FROM client WHERE last_name LIKE "%ez"

-- CONSULTA 10 top 3 planes on mas descuento
-- SELECT * FROM plan ORDER BY discount DESC LIMIT 3

