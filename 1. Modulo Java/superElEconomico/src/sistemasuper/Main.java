package sistemasuper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void showClients (List<Cliente> clientes){
        for(Cliente cliente : clientes){
            System.out.println(cliente.toString() + "\n");
        }
    }

    public static boolean findClient (List<Cliente> clientes, int dni) {
        boolean finded = false;
        for(Cliente cliente : clientes){
            if(cliente.getDni() == dni) {
                finded = true;
                System.out.println(cliente.toString());
                break;
            }
        }
        if (!finded){
            System.out.println("El cliente no esta en la lista");
        }
        return finded;
    }

    public static int pedirDni(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, introduce un dni: ");

        int dni = 0;
        // Leer un entero desde la entrada
        if (scanner.hasNextInt()) {
            dni = scanner.nextInt();
        } else {
            System.out.println("La entrada no es un número entero válido.");
        }
        return dni;
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(43667843, "Lucas", "Vilas");
        Cliente cliente2 = new Cliente(44556678, "Franco", "Sanchez");
        Cliente cliente3 = new Cliente(1248575, "Martin", "Juarez");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        showClients(clientes);

        clientes.remove(cliente2);
        showClients(clientes);

        int dni = pedirDni();
        findClient(clientes, dni);

        List<Item> items = new ArrayList<>();
        Factura factura1 = new Factura(cliente1, items, 0.0);
        List<Factura> facturasList = new ArrayList<>();

        if(!findClient(clientes, cliente1.getDni())){
            clientes.add(cliente1);
        }
        facturasList.add(factura1);

        Item item1 = new Item(1,"Leche", 2, 100.0);
        Item item2 = new Item(2,"Carne", 3, 150.0);
        factura1.addItem(item1);
        factura1.addItem(item2);

        for (Factura factura : facturasList) {
            System.out.println(factura);
        }


    }
}
