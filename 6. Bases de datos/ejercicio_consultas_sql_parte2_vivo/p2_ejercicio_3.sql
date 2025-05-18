DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;

USE empresa_internet;

DROP TABLE IF EXISTS contract;
DROP TABLE IF EXISTS plan;
DROP TABLE IF EXISTS client;


CREATE TABLE client(
	id_client INT AUTO_INCREMENT,
    dni BIGINT NOT NULL,
    name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    birthDate DATE NOT NULL,
    city VARCHAR(45) NULL,
    state VARCHAR(45),
    CONSTRAINT PK_Client PRIMARY KEY (id_client)
);

CREATE TABLE plan(
	id_plan INT AUTO_INCREMENT,
    megas INT NOT NULL,
    price DECIMAL(10, 2),
    discount DOUBLE(3, 1),
    CONSTRAINT PK_Plan PRIMARY KEY (id_plan)
);

CREATE TABLE contract(
	id_contract INT AUTO_INCREMENT,
	starDate DATETIME NOT NULL,
	endDate DATETIME NULL,
	id_client INT NOT NULL,
	id_plan INT NOT NULL,
	CONSTRAINT PK_id_contract PRIMARY KEY (id_contract),
	CONSTRAINT FK_Contract_Client FOREIGN KEY (id_client) REFERENCES Client (id_client),
	CONSTRAINT FK_Contract_Plan FOREIGN KEY (id_plan) REFERENCES Plan (id_plan)
);

------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO client (dni, name, last_name, birthDate, city, state) VALUES
(12233445, 'Juan', 'Pérez', '1985-01-15', 'Buenos Aires', 'BA'),
(23344556, 'María', 'García', '1990-04-25', 'Córdoba', 'CB'),
(34455667, 'Carlos', 'Sánchez', '1978-09-10', 'Rosario', 'SF'),
(45566778, 'Ana', 'Martínez', '1982-12-05', 'Mendoza', 'MZ'),
(56677889, 'Luisa', 'Rodríguez', '1993-07-22', 'Salta', 'SA'),
(67788990, 'Pedro', 'López', '1987-06-17', 'La Plata', 'BA'),
(78899001, 'Marta', 'Fernández', '1989-03-29', 'San Juan', 'SJ'),
(89900112, 'Ricardo', 'Gómez', '1975-05-06', 'Mar del Plata', 'BA'),
(90011223, 'Cecilia', 'Torres', '1999-08-30', 'Santa Fe', 'SF'),
(10122334, 'Sofía', 'Giménez', '1995-11-20', 'Neuquén', 'NQ');

INSERT INTO plan (megas, price, discount) VALUES
(20, 1800.00, 0.0),
(50, 2500.00, 2.5),
(100, 4000.00, 5.0),
(200, 7000.00, 8.0),
(500, 12000.00, 10.0);

INSERT INTO contract (starDate, endDate, id_client, id_plan) VALUES
('2023-01-10 09:00:00', NULL, 1, 1),    
('2022-11-15 17:30:00', '2024-01-10 08:59:59', 2, 2),  
('2023-04-01 12:00:00', NULL, 3, 1),    
('2023-05-20 10:00:00', NULL, 4, 3),    
('2023-06-11 11:30:00', NULL, 5, 4),    
('2023-07-21 14:50:00', NULL, 6, 2),   
('2023-08-01 07:45:00', '2023-11-01 07:45:00', 7, 3),  
('2023-09-10 16:20:00', NULL, 8, 5),   
('2023-10-02 13:00:00', NULL, 9, 4),   
('2023-10-20 15:15:00', NULL, 10, 2);  

