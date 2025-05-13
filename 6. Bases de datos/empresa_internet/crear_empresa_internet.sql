CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE `client` (
  `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `dni` VARCHAR(255),
  `nombre` VARCHAR(255),
  `apellido` VARCHAR(255),
  `fecha_de_nacimiento` DATE,
  `provincia` VARCHAR(255),
  `ciudad` VARCHAR(255),
  `plan_id` INT,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `plan` (
  `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `idx_plan` VARCHAR(255),
  `megas` INT,
  `precio` DECIMAL(10, 2),
  `descuento` DECIMAL(10, 2),
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE `client` ADD FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`);

INSERT INTO `plan` (idx_plan, megas, precio, descuento) VALUES
('Plan A', 500, 29.99, 0),
('Plan B', 1000, 49.99, 10),
('Plan C', 2000, 69.99, 5),
('Plan D', 3000, 89.99, 15),
('Plan E', 5000, 109.99, 20);

-- Ahora insertamos los clientes sin especificar el id porque es AUTO_INCREMENT
INSERT INTO `client` (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad, plan_id) VALUES
('12345678', 'Juan', 'Pérez', '1985-01-10', 'Buenos Aires', 'CABA', 1),
('87654321', 'Maria', 'López', '1990-05-15', 'Córdoba', 'Córdoba', 2),
('11223344', 'Carlos', 'Gómez', '1975-12-30', 'Buenos Aires', 'La Plata', 1),
('44332211', 'Laura', 'Martínez', '1988-08-20', 'Santa Fe', 'Santa Fe', 3),
('99887766', 'Pedro', 'Fernández', '1995-02-25', 'Mendoza', 'Mendoza', 2),
('55556666', 'Ana', 'Hernández', '2000-04-05', 'Tucumán', 'San Miguel de Tucumán', 4),
('66665555', 'Jorge', 'Jiménez', '1982-09-14', 'Neuquén', 'Neuquén', 3),
('44443333', 'Cecilia', 'Ramírez', '1998-03-11', 'Chaco', 'Resistencia', 5),
('77778888', 'Roberto', 'Fernández', '1978-06-23', 'Salta', 'Salta', 4),
('22221111', 'Lucía', 'Torres', '1991-11-01', 'Río Negro', 'Viedma', 5);










