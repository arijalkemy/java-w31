package EJINT_SupermercadoElEconomico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {
        //lista clientes
        List<Cliente> clientes = new ArrayList<Cliente>();

        //crear 3 clientes
        clientes.add(new Cliente("Manuela","Tonelli","42538617"));
        clientes.add(new Cliente("Trinidad","Tonelli","44567893"));
        clientes.add(new Cliente("Camila","Tonelli","23991222"));

        //mostrar datos de cada cliente
        System.out.println("Clientes registrados: ");
        for(Cliente cliente: clientes){
            System.out.println(cliente);
        }

        //eliminar cliente
        Iterator<Cliente> iterator = clientes.iterator();
        if (iterator.hasNext()){
            Cliente cliente = iterator.next(); //mover cursor
            iterator.remove(); //eliminar
        }

        //mostrar nuevamente lista de clientes
        System.out.println("\nClientes después de eliminar uno:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        //buscar cliente por dni
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el DNI del cliente a buscar: ");
        String dniBuscado = sc.nextLine();
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if(cliente.getDni().equals(dniBuscado)){
                System.out.println("\nCliente encontrado: " + cliente);
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            System.out.println("\nCliente no encontrado: " + dniBuscado);
        }

        sc.close();

    }
}
