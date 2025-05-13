DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE clientes (id int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
DNI varchar(20) NOT NULL,
first_name varchar(100) NOT NULL,
last_name varchar(100) NOT NULL,
birth_Date date NOT NULL,
city varchar(20),
state varchar(30));
DROP TABLE IF EXISTS `plan`;
CREATE TABLE plan (id int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
megas int(30) NOT NULL,
price decimal NOT NULL,
discount decimal NOT NULL,
client_id int(10) unsigned NOT NULL );
ALTER TABLE `plan` ADD FOREIGN KEY (`client_id`) REFERENCES `clientes` (`id`);
 
INSERT INTO clientes (DNI, first_name, last_name, birth_Date, city, state) VALUES
('12345678A', 'John', 'Doe', '1985-05-15', 'New York', 'NY'),
('23456789B', 'Jane', 'Smith', '1990-07-22', 'Los Angeles', 'CA'),
('34567890C', 'Alice', 'Johnson', '1972-11-03', 'Chicago', 'IL'),
('45678901D', 'Bob', 'Brown', '1980-02-14', 'Houston', 'TX'),
('56789012E', 'Charlie', 'Davis', '1995-08-23', 'Phoenix', 'AZ'),
('67890123F', 'Emily', 'Garcia', '1983-09-30', 'Philadelphia', 'PA'),
('78901234G', 'David', 'Wilson', '1988-12-10', 'San Antonio', 'TX'),
('89012345H', 'Emma', 'Martinez', '1992-03-25', 'San Diego', 'CA'),
('90123456I', 'Michael', 'Anderson', '1977-06-18', 'Dallas', 'TX'),
('01234567J', 'Olivia', 'Thomas', '1975-11-25', 'San Jose', 'CA');

INSERT INTO plan (megas, price, discount, client_id) VALUES
(500, 29.99, 5.00, 1),
(1000, 49.99, 10.00, 3),
(2000, 79.99, 15.00, 5),
(500, 29.99, 5.00, 7),
(1000, 49.99, 10.00, 8);
SELECT * FROM plan;

SELECT * FROM clientes;

SELECT * FROM clientes
WHERE state = "CA";

SELECT first_name FROM clientes ORDER BY first_name;

SELECT c.first_name , p.megas 
FROM clientes c INNER JOIN plan p
ON c.id = p.client_id
WHERE megas > 500;

SELECT * FROM clientes WHERE city = "Chicago";

SELECT * FROM clientes WHERE birth_Date BETWEEN "1985-01-01" AND "2000-01-01";

SELECT * FROM clientes WHERE city = "Los Angeles" AND state = "CA";

SELECT * FROM plan WHERE discount > 5 ;

SELECT * FROM plan WHERE price > 50 ;

