CREATE TABLE `cliente` (
  `id` integer PRIMARY KEY,
  `dni` integer,
  `nombre` varchar(255),
  `apellido` varchar(255),
  `fecha_nacimiento` datetime,
  `provincia` varchar(255),
  `ciudad` varchar(255),
  `plan_id` integer
);

CREATE TABLE `plan` (
  `id` integer PRIMARY KEY,
  `velocidad` integer,
  `precio` integer,
  `descuento` double
);

ALTER TABLE `cliente` ADD FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`);
