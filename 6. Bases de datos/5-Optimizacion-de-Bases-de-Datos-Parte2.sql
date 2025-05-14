
/*
Tenemos la siguiente tabla:
*/

CREATE TABLE tabla1 (
    id_factura INT(11) PRIMARY KEY,
    fecha_factura DATE,
    forma_pago DECIMAL(10,0),
    IVA DECIMAL(10,0),
    cantidad INT(11),
    importe DECIMAL(10,0),
    nombre_cliente VARCHAR(40),
    apellido_cliente VARCHAR(40),
    direccion_cliente VARCHAR(40),
    descripcion_articulo VARCHAR(40)
);

/*
Aplicar reglas de normalización y elaborar un modelo de DER que alcance la tercera forma normal (3FN):
Aplicamos la regla 2FN
*/

CREATE TABLE factura (
    id_factura INT(11) PRIMARY KEY,
    fecha_factura DATE,
    forma_pago DECIMAL(10,0),
    IVA DECIMAL(10,0),
    cantidad INT(11),
    importe DECIMAL(10,0),
    id_cliente INT(11),
    id_articulo INT(11)
);

CREATE TABLE cliente (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(40),
    apellido_cliente VARCHAR(40),
    direccion_cliente VARCHAR(40)
);

CREATE TABLE articulo (
    id INT(11),
    descripcion_articulo VARCHAR(40)
)
/*
Lo que hacemos para normalizar la tabla1 es identificar dentro entidades que se pueden separar en tablas separadas.
Por lo tanto podemos ver la entidad factura, cliente y articulo. Cada uno de estas entidades la separamos, ya que podemos encapsular atributos propios de las entidades en las tablas.
*/