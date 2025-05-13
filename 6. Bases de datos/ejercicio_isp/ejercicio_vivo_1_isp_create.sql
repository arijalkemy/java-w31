DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE Planes_Internet (
    id_plan INT PRIMARY KEY AUTO_INCREMENT,
    velocidad_mbps INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    descuento DECIMAL(5, 2) DEFAULT 0.00
);

CREATE TABLE Clientes (
    dni VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50),
    id_plan_contratado INT, -- FK

    FOREIGN KEY (id_plan_contratado) REFERENCES Planes_Internet(id_plan)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

INSERT INTO Planes_Internet (velocidad_mbps, precio, descuento) VALUES
(50, 1500.00, 5.00),
(100, 2000.00, 10.00),
(300, 2800.00, 15.00),
(500, 3500.00, 20.00),
(1000, 4500.00, 25.00);

INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan_contratado) VALUES
('11111111A', 'Juan', 'Perez', '1990-05-15', 'Buenos Aires', 'Capital Federal', 1), 
('22222222B', 'Maria', 'Gomez', '1985-11-20', 'Cordoba', 'Cordoba Capital', 2),
('33333333C', 'Carlos', 'Lopez', '1992-07-10', 'Santa Fe', 'Rosario', 1),   
('44444444D', 'Ana', 'Martinez', '1998-02-25', 'Mendoza', 'Ciudad de Mendoza', 3),
('55555555E', 'Pedro', 'Rodriguez', '1978-09-01', 'Buenos Aires', 'La Plata', 2), 
('66666666F', 'Laura', 'Fernandez', '1995-04-30', 'Cordoba', 'Villa Carlos Paz', 4), 
('77777777G', 'Pablo', 'Diaz', '1980-12-05', 'Santa Fe', 'Santa Fe Capital', 3), 
('88888888H', 'Sofia', 'Garcia', '1999-06-18', 'Mendoza', 'San Rafael', 5),   
('99999999I', 'Diego', 'Sanchez', '1993-01-22', 'Buenos Aires', 'Mar del Plata', 4),
('10101010J', 'Valeria', 'Torres', '1987-08-14', 'Cordoba', 'Rio Cuarto', 1);