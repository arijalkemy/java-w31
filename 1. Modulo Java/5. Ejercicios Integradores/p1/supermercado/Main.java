package supermercado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Cliente> clientes = crearClientes();
        imprimirClientes(clientes);

        eliminarCliente(clientes, 2);
        imprimirClientes(clientes);

        buscarClientePorDni(clientes);
    }

    private static List<Cliente> crearClientes() {
        Cliente cliente1 = new Cliente(111, "Juan", "Perez");
        Cliente cliente2 = new Cliente(222, "Maria", "Perez");
        Cliente cliente3 = new Cliente(333, "Carlos", "Perez");

        return new ArrayList<>(Arrays.asList(cliente1, cliente2, cliente3));
    }

    private static void imprimirClientes(List<Cliente> clientes) {
        System.out.println("Lista de clientes:");
        clientes.stream()
                .map(Cliente::toString)
                .forEach(System.out::println);
    }

    private static void eliminarCliente(List<Cliente> clientes, int id) {
        clientes.removeIf(cliente -> cliente.getDni() == id);
        System.out.println("Cliente con ID " + id + " eliminado.");
    }

    private static void buscarClientePorDni(List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del cliente a buscar: ");
        String dni = scanner.nextLine();

        List<Cliente> resultado = clientes.stream()
                .filter(cliente -> cliente.getDni() == Integer.parseInt(dni))
                .collect(Collectors.toList());

        if (resultado.isEmpty()) {
            System.out.println("No se encontró ningún cliente con el DNI ingresado.");
        } else {
            System.out.println("Cliente encontrado: " + resultado.get(0));
        }
    }
}
