package co.com.mercadolibre.supermercadoeleconomico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.com.mercadolibre.supermercadoeleconomico.domain.Cliente;
import co.com.mercadolibre.supermercadoeleconomico.domain.Factura;
import co.com.mercadolibre.supermercadoeleconomico.domain.Item;
import co.com.mercadolibre.supermercadoeleconomico.servicesImplementations.ClienteCrudImpl;
import co.com.mercadolibre.supermercadoeleconomico.servicesImplementations.FacturaCrudImpl;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ClienteCrudImpl clienteCRUD = new ClienteCrudImpl();
    private static FacturaCrudImpl facturaCRUD = new FacturaCrudImpl();

    public static void main(String[] args) {
        cargarClientesIniciales();
        mostrarClientes();

        eliminarCliente("87654321");
        System.out.println("\nClientes después de eliminar el cliente con DNI 87654321:");
        mostrarClientes();

        buscarCliente();

        crearFactura();

        // Mostrar todas las facturas almacenadas
        System.out.println("\nListado de Facturas:");
        for (Factura factura : facturaCRUD.readAll()) {
            System.out.println(factura);
        }

        scanner.close();
    }

    private static void cargarClientesIniciales() {
        clienteCRUD.create(new Cliente("12345678", "Juan", "Pérez"));
        clienteCRUD.create(new Cliente("87654321", "María", "González"));
        clienteCRUD.create(new Cliente("11223344", "Carlos", "Ramírez"));
    }

    private static void mostrarClientes() {
        System.out.println("Listado de Clientes:");
        for (Cliente cliente : clienteCRUD.readAll()) {
            System.out.println(cliente);
        }
    }

    private static void eliminarCliente(String dni) {
        clienteCRUD.delete(dni);
        System.out.println("\nCliente con DNI " + dni + " eliminado (si existía).");
    }

    private static void buscarCliente() {
        System.out.print("\nIngrese el DNI del cliente a buscar: ");
        String dniBuscar = scanner.nextLine();
        Cliente cliente = clienteCRUD.read(dniBuscar);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente con DNI " + dniBuscar + " no se encuentra en la lista.");
        }
    }

    private static void crearFactura() {
        // Solicitar el DNI del cliente para la factura
        System.out.print("\nIngrese el DNI del cliente para la factura: ");
        String dni = scanner.nextLine();
        Cliente cliente = clienteCRUD.read(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Ingrese los datos para crear un nuevo cliente.");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            cliente = new Cliente(dni, nombre, apellido);
            clienteCRUD.create(cliente);
            System.out.println("Cliente creado exitosamente: " + cliente);
        }

        List<Item> itemsFactura = new ArrayList<>();
        System.out.print("\n¿Cuántos ítems desea agregar a la factura? ");
        int cantidadItems = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= cantidadItems; i++) {
            System.out.println("\n--- Datos del ítem " + i + " ---");
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            System.out.print("Nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            System.out.print("Costo Unitario: ");
            double costoUnitario = Double.parseDouble(scanner.nextLine());

            Item item = new Item(codigo, nombreProducto, cantidad, costoUnitario);
            itemsFactura.add(item);
        }

        Factura factura = new Factura(cliente, itemsFactura);
        facturaCRUD.create(factura);
        System.out.println("\nFactura creada exitosamente:");
        System.out.println(factura);
    }
}
