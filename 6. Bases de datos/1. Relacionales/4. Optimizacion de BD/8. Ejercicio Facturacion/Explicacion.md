La estructura de base de datos dada ya se encontraba en 1FN debido a que los valores de cada atributo son atómicos.

Se consigue convertir el esquema a 2FN al separar en tablas independientes los datos del cliente y del articulo ya que no dependen del identificador de la factura. Se establece una relación de uno a muchos entre clientes y facturas, y una relación de muchos a muchos entre factura y articulo por lo que aparece una tabla intermedia que además indica la cantidad de cada articulo para cada factura.

No es necesario realizar ningun otro cambio para alcanzar 3FN ya que no hay dependencias transitivas entre la llave primaria de cada tabla y los otros atributos de la misma.