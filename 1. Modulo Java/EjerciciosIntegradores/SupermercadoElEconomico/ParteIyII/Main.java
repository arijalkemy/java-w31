package EjerciciosIntegradores.SupermercadoElEconomico.ParteIyII;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Un supermercado desea implementar un sistema, que le permita almacenar los
 * datos de sus clientes y distintas facturas de las compras que los
 * mencionados realicen. Para esto,  necesita poder realizar operaciones de
 * creación, consulta, eliminación o actualización de datos de  todos los
 * clientes y sus respectivas facturas asociadas.
 * 
 * De cada cliente se registran: dni, nombre y apellido. Por otro lado, las
 * facturas que se generan cuando un cliente hace una compra contienen a un
 * cliente, una lista de ítems y el total de la compra. De cada item o
 * producto se guarda el código, nombre, cantidad comprada y costo unitario. 
 * 
 * Dada la complejidad que posee el sistema, el Project Manager que dirige el
 * proyecto ha decidido realizarlo en dos sprints, donde cada uno de ellos 
 * tendrá como objetivo una entrega final de una serie de requerimientos.
 * 
 * Parte I
 * Se necesita:
 *  - Crear el modelo de clases que conforman, una factura, los cuales son:
 *    Cliente, Item, Factura.
 *  - Crear 3 clientes y guardarlos en una collection.
 *  - Recorrer la collection de clientes y mostrar por pantalla los datos de
 *    cada uno de ellos. 
 *  - Eliminar uno de los clientes de la lista y volver a consultar e imprimir
 *    todos los clientes restantes.
 *  - Solicitar por teclado un número de dni de un cliente para buscarlo. En
 *    caso de que el cliente se encuentre en la lista, mostrar sus datos, caso
 *    contrario, mostrar un mensaje que informe dicha situación.
 * 
 * Parte II
 * Crear una nueva factura.
 * Antes de querer agregar una factura a una collection de facturas tener en
 * cuenta que:
 *  - Será necesario validar si el cliente asociado a la factura se encuentra
 *    registrado en la collection de clientes. En caso de que no, el mismo deberá
 *    ser creado.
 *  - Será necesario crear una lista de items y asociarla a la factura creada.
 *  - El campo total de la factura es un campo calculado, por lo cual, para
 *    poder asignar este valor deberemos recorrer la lista de items y realizar
 *    las operaciones matemáticas necesarias para obtener el total.
 */
public class Main {
    public static void main(String[] args) {

        // Parte I
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente((long) 12345678, "Juan", "Pérez"));
        clientes.add(new Cliente((long) 87654321, "María", "Gómez"));
        clientes.add(new Cliente((long) 11223344, "Pedro", "López"));

        System.out.println("Lista de clientes:");
        clientes.forEach(cliente -> System.out.println(cliente.getNombre() + " " + cliente.getApellido() + ", DNI: " + cliente.getDni()));

        clientes.removeIf(cliente -> cliente.getDni().equals((long) 12345678));
        System.out.println("\nLista de clientes después de eliminar a Juan Pérez:");
        clientes.forEach(cliente -> System.out.println(cliente.getNombre() + " " + cliente.getApellido() + ", DNI: " + cliente.getDni()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el DNI del cliente a buscar: ");
        Long dniBuscado = scanner.nextLong();
        boolean encontrado = false;
        for (Cliente cliente: clientes) {
            if (cliente.getDni().equals(dniBuscado)) {
                System.out.println("Cliente encontrado: " + cliente.getNombre() + " " + cliente.getApellido());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }
        scanner.close();

        // Parte II
        List<Factura> facturas = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        items.add(new Item("Leche", 2, 1.50)); 
        items.add(new Item("Pan", 1, 0.80));
        items.add(new Item("Huevos", 12, 0.10));
        items.add(new Item("Carne", 1, 5.00));
        
        System.out.println("\nCreando una factura...");
        Factura factura1 = new Factura(new Cliente((long) 84729234, "Mariana", "Sanchez"), items);
        
        if (clientes.contains(factura1.getCliente())) {
            facturas.add(factura1);
            System.out.println("\nFactura 1 creada para el cliente " + factura1.getCliente().getNombre() + " " + factura1.getCliente().getApellido());
        } else {
            System.out.println("\nEl cliente no se encuentra registrado. Creando nuevo cliente...");
            clientes.add(factura1.getCliente());
            facturas.add(factura1);
            System.out.println("Factura 1 creada para el nuevo cliente " + factura1.getCliente().getNombre() + " " + factura1.getCliente().getApellido());
        }

    }
}
