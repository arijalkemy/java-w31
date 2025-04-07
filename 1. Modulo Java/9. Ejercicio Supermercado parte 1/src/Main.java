//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
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
    }
}