# Pasos de la descomposición

### 1FN

La tabla ya esta en 1FN, asumiendo que los valores que se van a meter son atomicos.

## 2FN

Si asumimos que hay varios articulos, la clave primaria sería compuesta (id_factura, descripcion_articulo).
nombre_cliente, apellido_cliente, direccion_cliente, fecha_factura, forma_pago, IVA dependen solo de id_factura.
Ya podemos separar las cosas en Factura, Cliente, FacturaCliente y DetalleFactura.

## 3FN

Para cumplir con 3FN deberiamos tener el articulo de DetalleFactura separado del detalle.
Nos puede quedar algo asi:

4 entidades:
* Factura(id_factura, fecha_factura, forma_pago, importe, IVA) (importe se podria calcular con un campo unitario en los Articulos)
* Cliente(id_cliente, nombre, apellido, direccion)
* Articulo(id_articulo, descripcion, precio_unitario (si es que se puede agregar el campo))
* DetalleFactura(id_factura, id_articulo, cantidad)

y ademas agregar una tabla intermedia FacturaCliente para relacionar a los clientes con sus facturas.