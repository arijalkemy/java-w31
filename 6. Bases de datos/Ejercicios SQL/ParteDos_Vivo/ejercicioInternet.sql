Ejercicio 1: Modelado mediante un DER (Diagrama Entidad-Relación)

Para el Diagrama Entidad-Relación (DER):
--Clientes
DNI (PK)
Nombre
Apellido
Fecha de Nacimiento
Provincia
Ciudad
id_plan (FK)

--Planes de Internet
ID_Plan (PK)
Velocidad 
Precio
Descuento

--Relaciones:
Un cliente puede tener un solo plan de internet, y un plan puede ser utilizado por múltiples clientes. 
Esto indica que existe una relación de uno a muchos entre Planes de Internet y Clientes.

--Ejercicio 2
a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta

La primary key (PK) para la tabla de clientes es el DNI. Justificación:

El DNI (Documento Nacional de Identidad) es único para cada cliente y puede ser usado para identificar de manera 
inequívoca a un cliente en la base de datos. No se repite ni se comparte entre diferentes individuos.


b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
La primary key para la tabla de planes de internet es el ID_Plan. Justificación:

Este campo es único para cada plan de internet ofrecido por la empresa. Permite identificar cada plan sin 
ambigüedades y asegurar que no existan planes duplicados.

c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? 
¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.

La relación entre la tabla de Clientes y la tabla de Planes de Internet es de uno a muchos. Por lo tanto, 
la tabla Clientes debe tener un campo de foreign key (FK).
La FK en la tabla Clientes sería ID_Plan, que haría referencia a ID_Plan en la tabla Planes de Internet. 

Justificación:
Al almacenar el ID del plan en la tabla de clientes, podemos asociar a cada cliente con el plan que ha contratado, 
permitiendo que un plan se aplique a múltiples clientes.

Ejercicio 3
Para crear la base de datos empresa_internet y las tablas:

CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE Planes_Internet (
    ID_Plan INT PRIMARY KEY AUTO_INCREMENT,
    Velocidad INT NOT NULL,
    Precio DECIMAL(10, 2) NOT NULL,
    Descuento DECIMAL(5, 2)
);

CREATE TABLE Clientes (
    DNI VARCHAR(15) PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Fecha_Nacimiento DATE,
    Provincia VARCHAR(50),
    Ciudad VARCHAR(50),
    ID_Plan INT,
    FOREIGN KEY (ID_Plan) REFERENCES Planes_Internet(ID_Plan)
);

Insert de los 10 registros
INSERT INTO Planes_Internet (Velocidad, Precio, Descuento) VALUES
(50, 29.99, 0),
(100, 49.99, 5),
(200, 69.99, 10),
(300, 89.99, 15),
(1000, 149.99, 20);

INSERT INTO Clientes (DNI, Nombre, Apellido, Fecha_Nacimiento, Provincia, Ciudad, ID_Plan) VALUES
('12345678A', 'Juan', 'Pérez', '1980-05-21', 'Buenos Aires', 'La Plata', 1),
('87654321B', 'María', 'Gómez', '1990-08-14', 'CABA', 'Buenos Aires', 2),
('11223344C', 'Luis', 'Fernández', '1985-11-10', 'Córdoba', 'Córdoba', 3),
('22334455D', 'Ana', 'Martínez', '1995-02-27', 'Mendoza', 'Mendoza', 4),
('33445566E', 'Carlos', 'López', '1978-03-15', 'Santa Fe', 'Santa Fe', 1),
('44556677F', 'Laura', 'Sánchez', '1992-09-12', 'Tucumán', 'San Miguel de Tucumán', 2),
('55667788G', 'Pedro', 'Ramírez', '1988-07-30', 'Neuquén', 'Neuquén', 3),
('66778899H', 'Jessica', 'Díaz', '1997-06-05', 'Buenos Aires', 'Morón', 4),
('77889900I', 'Ricardo', 'Hernández', '1983-04-21', 'CABA', 'Buenos Aires', 1),
('88990011J', 'Sofía', 'Torres', '1991-10-16', 'Salta', 'Salta', 5);

Ejercicio 4: Consultas SQL

1) Consultar todos los clientes y sus planes asociados:
SELECT c.DNI, c.Nombre, c.Apellido, p.Velocidad, p.Precio 
FROM Clientes c 
JOIN Planes_Internet p ON c.ID_Plan = p.ID_Plan;

2) Consultar clientes específicos por ciudad:
SELECT * FROM Clientes WHERE Ciudad = 'Buenos Aires';

3) Consultar todos los planes disponibles:
SELECT * FROM Planes_Internet;

4) Contar cuántos clientes hay por cada plan:
SELECT ID_Plan, COUNT(*) AS Cantidad_Clientes 
FROM Clientes 
GROUP BY ID_Plan;

5) Consultar el cliente con el plan más caro:
SELECT c.* 
FROM Clientes c 
JOIN Planes_Internet p ON c.ID_Plan = p.ID_Plan 
ORDER BY p.Precio DESC LIMIT 1;

6) Consultar todos los clientes con descuento en su plan:
SELECT c.* 
FROM Clientes c 
JOIN Planes_Internet p ON c.ID_Plan = p.ID_Plan 
WHERE p.Descuento > 0;

7) Consultar clientes nacidos después de 1990:
SELECT * FROM Clientes WHERE Fecha_Nacimiento > '1990-01-01';

8)Actualizar el precio de un plan específico (ID_Plan = 1):
UPDATE Planes_Internet SET Precio = 34.99 WHERE ID_Plan = 1;

9)Eliminar un cliente específico (DNI = '12345678A'):
DELETE FROM Clientes WHERE DNI = '12345678A';

10)Consultar planes con velocidad mayor a 100 megas:
SELECT * FROM Planes_Internet WHERE Velocidad > 100;