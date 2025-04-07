package org.example;

import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Cliente cliente1 = new Cliente("1","Juan","Duran");
        Cliente cliente2 = new Cliente("2", "Brayan", "Quintero");
        Cliente cliente3 = new Cliente("3", "Vanessa", "Tolosa");


        Collection<Cliente> clientes= new ArrayList<>();

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        clientes.forEach(System.out::println);

        clientes.remove(cliente2);

        System.out.println("--------Se elimina el segundo cliente--------");
        clientes.forEach(System.out::println);

        //Pidiendo datos por scanner al usuario
        String dni = sc.nextLine();

        List<Cliente> clientesList = clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).toList();

        if(!clientesList.isEmpty()){
            clientesList.forEach(System.out::println);
        }else{
            throw new Exception("No fue encontrado el cliente con dni: "+dni);
        }

    }
}