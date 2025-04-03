package supermercadoElEconomico;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(414141414, "Carlos", "Ramirez");
        Cliente cliente2 = new Cliente(414141415, "Ramon", "Martinez");
        Cliente cliente3 = new Cliente(414141416, "Carlos", "Ramirez");

        Repository<Cliente, Integer> clientRepository = new Repository<>();
        clientRepository.save(cliente1);
        clientRepository.save(cliente2);
        clientRepository.save(cliente3);

        Repository<Factura, Integer> facturaRepository = new Repository<>();
        List<Item> items = new ArrayList<>();
        Item atun = new Item("Lata de atún", "AABBCC", 3.90F, 3);
        items.add(atun);
        Item manteca = new Item("Manteca", "AAAEEE", 4.90F, 2);
        items.add(manteca);
        Item aceite = new Item("Aceite", "AAADDD", 2.70F, 2);
        items.add(aceite);
        Item arroz = new Item("Arroz", "HHHJJJ", 2.30F, 2);
        items.add(arroz);

        Factura factura1 = new Factura(cliente1, items);
        facturaRepository.save(factura1);

        System.out.println(factura1);

        for (Cliente cliente : clientRepository.findAll()) {
            System.out.println(cliente);
        }

        clientRepository.delete(414141415);
        for (Cliente cliente : clientRepository.findAll()) {
            System.out.println(cliente);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dni del cliente a buscar: ");
        String dni = sc.nextLine();
        int parsedDni = Integer.parseInt(dni);

        Cliente cliente = clientRepository.findById(parsedDni);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("No se encontro el cliente");
        }



    }
}
