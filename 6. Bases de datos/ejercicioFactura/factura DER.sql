CREATE TABLE `factura` (
  `id` integer PRIMARY KEY,
  `id_cliente` integer NOT NULL,
  `fecha` date,
  `forma_pago` decimal(10,0),
  `IVA` decimal(10,0),
  `cantidad` integer,
  `importe` decimal(10,0)
);

CREATE TABLE `cliente` (
  `id` integer PRIMARY KEY,
  `nombre` varchar(40),
  `apellido` varchar(40),
  `direccion` carchar(40)
);

CREATE TABLE `articulo_factura` (
  `id_articulo` integer,
  `id_factura` integer,
  PRIMARY KEY (`id_articulo`, `id_factura`)
);

CREATE TABLE `articulo` (
  `id` integer PRIMARY KEY,
  `nombre` varchar(40),
  `descripcion` varchar(40)
);

ALTER TABLE `factura` ADD CONSTRAINT `facturas_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);

ALTER TABLE `articulo_factura` ADD FOREIGN KEY (`id_articulo`) REFERENCES `articulo` (`id`);

ALTER TABLE `articulo_factura` ADD FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id`);
