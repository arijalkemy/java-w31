package EJINT_SupermercadoElEconomico;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    private static Scanner scanner = new Scanner(System.in);
    private static ClienteCRUD clienteService = new ClienteCRUD();
    private static final FacturaCRUD facturaService = new FacturaCRUD();

    public static void main(String[] args) {
        agregarClientesIniciales();
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    crearFactura();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void agregarClientesIniciales() {
        clienteService.crear(new Cliente("Manuela", "Tonelli", "42538617"));
        clienteService.crear(new Cliente("Trinidad", "Tonelli", "44201652"));
    }

    private static void mostrarMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Crear factura");
        System.out.println("2. Consultar cliente");
        System.out.println("3. Listar clientes");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearFactura() {
        System.out.print("Ingrese el DNI del cliente: ");
        String dniCliente = scanner.nextLine();
        Cliente cliente = clienteService.leer(dniCliente);

        if (cliente == null) {
            System.out.print("Cliente no encontrado. Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido: ");
            String apellido = scanner.nextLine();
            cliente = new Cliente(dniCliente, nombre, apellido);
            clienteService.crear(cliente);
        }

        Factura factura = new Factura(cliente);
        agregarItemsAFactura(factura);
        facturaService.crear(factura);
        System.out.println("Factura creada:\n" + factura);
    }

    private static void agregarItemsAFactura(Factura factura) {
        while (true) {
            System.out.print("Ingrese el código del ítem (o 'salir' para finalizar): ");
            String codigo = scanner.nextLine();
            if (codigo.equalsIgnoreCase("salir")) {
                break; // Salir del ciclo
            }
            System.out.print("Ingrese el nombre del ítem: ");
            String nombreItem = scanner.nextLine();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el costo unitario: ");
            double costoUnitario = Double.parseDouble(scanner.nextLine());

            Item item = new Item(nombreItem, cantidad, costoUnitario,codigo);
            factura.agregarItem(item);
        }
    }

    private static void consultarCliente() {
        System.out.print("Ingrese el DNI del cliente: ");
        String dniCliente = scanner.nextLine();
        Cliente cliente = clienteService.leer(dniCliente);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void listarClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clienteService.getClientes()) {
            System.out.println(cliente);
        }
    }
}
