import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // --------------------------------------------------------------------------------------------
        // Parte 1

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("12345678", "Jose", "Perez"));
        clientes.add(new Cliente("87654321", "Juan", "Gutierrez"));
        clientes.add(new Cliente("18273645", "Pedro", "Garcia"));

        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

        System.out.println("--------------------------");

        clientes.removeFirst();

        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

        System.out.println("--------------------------");

        buscarCliente(clientes);

        // --------------------------------------------------------------------------------------------
        // Parte 2

        Cliente clienteFactura = new Cliente("45362718", "Gabriela", "Alvarez");

        if (!clientes.contains(clienteFactura)) {
            clientes.add(clienteFactura);
        }

        Factura factura = new Factura(clienteFactura, new ArrayList<>(), 0D);

        List<Item> itemsFactura = new ArrayList<>();

        Item item1 = new Item("123", "Guantes", 100D, 5);
        Item item2 = new Item("456", "Detergente", 200D, 2);
        Item item3 = new Item("789", "Esponja", 300D, 1);

        itemsFactura.add(item1);
        itemsFactura.add(item2);
        itemsFactura.add(item3);

        factura.setItems(itemsFactura);
    }

    public static void buscarCliente(List<Cliente> clientes) {
        System.out.println("Ingrese el DNI a buscar: ");
        Scanner scanner = new Scanner(System.in);
        String dniABuscar = scanner.next();
        scanner.close();

        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (dniABuscar.equals(cliente.getDni())) {
                clienteEncontrado = cliente;
            }
        }

        if (clienteEncontrado != null) {
            System.out.println("Se encontro un cliente con ese DNI: ");
            System.out.println(clienteEncontrado.toString());
        } else {
            System.out.println("No se encontro un cliente con ese DNI");
        }
    }
}
