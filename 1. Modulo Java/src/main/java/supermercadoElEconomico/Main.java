package supermercadoElEconomico;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(414141414, "Carlos", "Ramirez");
        Cliente cliente2 = new Cliente(414141415, "Ramon", "Martinez");
        Cliente cliente3 = new Cliente(414141416, "Carlos", "Ramirez");

        Map<Integer, Cliente> clientesMap = new HashMap<>();
        clientesMap.put(414141414, cliente1);
        clientesMap.put(414141415, cliente2);
        clientesMap.put(414141416, cliente3);

        for (Cliente cliente : clientesMap.values()) {
            System.out.println(cliente);
        }

        clientesMap.remove(414141415);
        for (Cliente cliente : clientesMap.values()) {
            System.out.println(cliente);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dni del cliente a buscar: ");
        String dni = sc.nextLine();
        int parsedDni = Integer.parseInt(dni);

        if (clientesMap.containsKey(parsedDni)) {
            System.out.println(clientesMap.get(parsedDni));
        } else {
            System.out.println("El cliente no existe");
        }

    }
}
