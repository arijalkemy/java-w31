package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(12365458L, "Juan", "Pérez"));
        clientes.add(new Cliente(12365458L, "María", "Gómez"));
        clientes.add(new Cliente(12365458L, "Carlos", "López"));

        System.out.println("Lista de clientes:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }


        clientes.remove(1);
        System.out.println("\nLista de clientes después de eliminar a María:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }


        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el DNI del cliente a buscar: ");
        String dniBuscado = scanner.nextLine();

        boolean encontrado = false;
        for (Cliente c : clientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("Cliente encontrado: " + c);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }
    }

}
