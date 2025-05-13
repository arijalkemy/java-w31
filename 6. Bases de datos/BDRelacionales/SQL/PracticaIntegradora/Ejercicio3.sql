-- Crear base de datos
CREATE DATABASE empresa_internet;

-- Seleccionar la base de datos recién creada
USE empresa_internet;

-- Crear la tabla de planes de internet
CREATE TABLE planes_internet (
    id_plan INT AUTO_INCREMENT PRIMARY KEY,
    velocidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    descuento DECIMAL(5,2) DEFAULT 0
);

-- Crear la tabla de clientes
CREATE TABLE clientes (
    dni VARCHAR(8) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    id_plan INT,
    FOREIGN KEY (id_plan) REFERENCES planes_internet(id_plan)
);

-- Insertar 5 planes de internet
INSERT INTO planes_internet (velocidad, precio, descuento) VALUES
    (50, 29.99, 0),
    (100, 39.99, 5.00),
    (200, 49.99, 7.50),
    (300, 59.99, 10.00),
    (500, 79.99, 15.00);

-- Insertar 10 clientes
INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES
    ('12345678', 'Juan',    'Pérez',     '1980-01-15', 'Buenos Aires', 'La Plata',    1),
    ('23456789', 'María',   'González',  '1990-02-20', 'Córdoba',      'Córdoba',     2),
    ('34567890', 'Pedro',   'Martínez',  '1985-03-25', 'Santa Fe',     'Rosario',     3),
    ('45678901', 'Ana',     'López',     '1992-04-10', 'Mendoza',      'Mendoza',     4),
    ('56789012', 'Luis',    'Fernández', '1978-05-05', 'Buenos Aires', 'Rosario',     5),
    ('67890123', 'Laura',   'Díaz',      '1988-06-15', 'Entre Ríos',   'Paraná',      1),
    ('78901234', 'Sofía',   'García',    '1995-07-08', 'Salta',        'Salta',       2),
    ('89012345', 'Diego',   'Sánchez',   '1983-08-20', 'Corrientes',   'Corrientes',  3),
    ('90123456', 'Elena',   'Torres',    '1991-09-30', 'Chaco',        'Resistencia', 4),
    ('01234567', 'Mario',   'Ramírez',   '1986-10-12', 'Formosa',      'Clorinda',    5);