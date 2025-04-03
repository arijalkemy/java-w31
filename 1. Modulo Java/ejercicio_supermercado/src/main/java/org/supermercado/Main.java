package org.supermercado;

import org.supermercado.clases.Cliente;
import org.supermercado.clases.Factura;
import org.supermercado.clases.Item;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Crear 3 clientes y guardarlos en una collection.
        Cliente c1 = new Cliente(42643178L, "Juan", "Bellavitis");
        Cliente c2 = new Cliente(42315409L, "Rocio", "Baldo");
        Cliente c3 = new Cliente(11223344L, "John", "Doe");

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        // Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos
        clientes.forEach(c -> System.out.println(c.toString()));

        System.out.println("---------------------------------------------");

        // Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente a borrar: ");
        Long dniBorrar = scanner.nextLong();
        boolean clienteBorrado = false;

        for(Cliente cliente : clientes) {
            if(cliente.getDni().equals(dniBorrar)) {
                clientes.remove(cliente);
                clienteBorrado = true;
                break;
            }
        }

        if(!clienteBorrado) {
            System.out.println("No se encuentra el cliente");
        }

        clientes.forEach(c -> System.out.println(c.toString()));

        System.out.println("---------------------------------------------");

        System.out.println("Ingrese el dni del cliente: ");
        Long dni = scanner.nextLong();
        boolean flag = false;

        for(Cliente cliente : clientes) {
            if(cliente.getDni().equals(dni)) {
                System.out.println("-- CLIENTE ENCONTRADO --");
                System.out.println("DNI: " + cliente.getDni());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("El cliente no existe");
        }


        // TODO: HACER VALIDACIONES
        // Parte II
        System.out.println("---------------------------------------------");
        System.out.println(" -- CREACION DE FACTURAS --");

        System.out.println("Ingrese el dni del cliente: ");
        Long scannerDni = scanner.nextLong();
        Factura factura = new Factura();
        Cliente clienteNuevo = new Cliente();

        List<Item> itemList = new ArrayList<>();
        int codigo = 1;

        while (true) {
            System.out.println("Ingrese el nombre del item (o 'salir' para terminar): ");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Ingrese la cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el precio: ");
            double precio = Double.parseDouble(scanner.nextLine());

            Item item = new Item(codigo, nombre, cantidad, precio);
            itemList.add(item);
            codigo++;
        }

        boolean foundDni = false;

        for(Cliente cliente : clientes) {
            if(cliente.getDni().equals(scannerDni)) {
                System.out.println("-- CLIENTE ENCONTRADO --");
                foundDni = true;
                break;
            }
        }

        if(!foundDni) {
            System.out.println("Ingrese un nombre del cliente: ");
            String nombre = scanner.next();
            System.out.println("Ingrese el apellido del cliente: ");
            String apellido = scanner.next();

            clienteNuevo = new Cliente(scannerDni, nombre, apellido);
            System.out.println("El cliente fue registrado con éxito");
        }

        double totalCompra = 0;

        for (Item item : itemList) {
            totalCompra += item.getCostoUnitario() * item.getCantidadComprada();
        }

        factura = new Factura(clienteNuevo, itemList, totalCompra);

        System.out.println("---------------------------------------------");

        System.out.println("-- FACTURA CREADA --");
        System.out.println("CLIENTE:" + factura.getCliente());
        System.out.println("ITEMS:" + factura.getItems().toString());
        System.out.println("TOTAL COMPRA:" + factura.getTotalCompra());
    }
}