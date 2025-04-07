//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Factura> facturas = new ArrayList<>();

    public static void main(String[] args) {
        clientes.add(new Cliente("12345678", "Juan", "Perez"));
        clientes.add(new Cliente("87654321", "Ana", "Gomez"));
        clientes.add(new Cliente("11223344", "Pedro", "Lopez"));

        System.out.println("Lista de clientes:");
        clientes.forEach(System.out::println);

        clientes.removeIf(cliente -> cliente.getDni().equals("87654321"));

        System.out.println("\nLista de clientes después de eliminar uno:");
        clientes.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngresa el DNI de un cliente a buscar: ");
        String dniABuscar = scanner.nextLine();
        clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniABuscar))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Cliente con DNI " + dniABuscar + " no encontrado.")
                );

        System.out.print("\nCrear nueva factura. Ingrese el DNI del cliente: ");
        String dniCliente = scanner.nextLine();
        Cliente cliente = buscarOcrearCliente(dniCliente, scanner);

        List<Item> items = crearListaItems(scanner);
        Factura nuevaFactura = new Factura(cliente, items);
        facturas.add(nuevaFactura);

        System.out.println("\nFacturas:");
        facturas.forEach(System.out::println);
    }

    private static Cliente buscarOcrearCliente(String dni, Scanner scanner) {
        Optional<Cliente> clienteOpt = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst();

        if (clienteOpt.isPresent()) {
            return clienteOpt.get();
        } else {
            System.out.print("Cliente no encontrado. Ingrese nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese apellido: ");
            String apellido = scanner.nextLine();
            Cliente nuevoCliente = new Cliente(dni, nombre, apellido);
            clientes.add(nuevoCliente);
            return nuevoCliente;
        }
    }

    private static List<Item> crearListaItems(Scanner scanner) {
        List<Item> items = new ArrayList<>();
        System.out.print("\nIngrese la cantidad de ítems a añadir: ");
        int cantidadItems = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cantidadItems; i++) {
            System.out.print("Código del ítem: ");
            String codigo = scanner.nextLine();
            System.out.print("Nombre del ítem: ");
            String nombre = scanner.nextLine();
            System.out.print("Cantidad comprada: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            System.out.print("Costo unitario: ");
            double costo = Double.parseDouble(scanner.nextLine());
            items.add(new Item(codigo, nombre, cantidad, costo));
        }
        return items;
    }
}