# Práctica entidad relación (DER) Mueblería


## Enunciado
 Una mueblería necesita la implementación de una base de datos para controlar las ventas que realiza por día, el stock de sus artículos (productos) y la lista de sus clientes que realizan las compras.

### QA
1. **¿Cuáles serían las entidades de este sistema?**
	**R/** Las entidades del sistema son Customer, Order, Products, de modo que se tiene un cliente que realiza una orden cuya orden contiene productos, entiendase orden como un medio para realizar la compra de uno o más productos que un cliente "Customer" quiera adquirir
2. **¿Qué atributos se determinarán para cada entidad? (Considerar los que se crean necesarios)** 
**R/** Por facilidad no se considera ningún atributo, sin embargo para futuras ocasiones se podrían considerar atributos en el cliente cómo su identificación nacional, nombre, apellido, para la orden id de la orden, consecutivo de orden, fecha de emisión, y finalmente los productos tendrán un id, nombre y cantidad
3.  **¿Cómo se conformarán las relaciones entre entidades? ¿Cuáles serían las cardinalidades?**
**R/** las relaciones y cardinalidades de las mismas se conforman bajo el siguiente flujo, un Cliente realiza una o más ordenes (relación uno a muchos) y muchas ordenes tienen muchos productos (relación muchos a muchos), NOTA: Se debe crear una tabla intermedia entre estás 2 entidades relacionando sus correspondientes primary keys, cómo foreign keys de la tabla intermedia resultante
4. **Realizar un DER para modelar el escenario planteado**.

![der](https://i.postimg.cc/XY7YXXk9/Untitled-Diagram.jpg)

