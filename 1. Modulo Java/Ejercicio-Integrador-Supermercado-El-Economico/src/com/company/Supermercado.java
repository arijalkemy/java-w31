package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {
        //Creación de tres clientes
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente("38220103","Miguel","Bustos"));
        listaClientes.add(new Cliente("17124862","Carlos","Bustos"));
        listaClientes.add(new Cliente("35768819","Jose","Bustos"));

        //Recorrer y mostrar clientes
        System.out.println("Lista de Clientes: ");
        listaClientes.forEach(System.out::println);

        //Eliminar un cliente
        listaClientes.remove(1);

        //Mostrar nuevamente
        System.out.println("Lista de clientes luego de eliminar uno: ");
        listaClientes.forEach(System.out::println);

        //Ingreso de dni por teclado:
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese un dni a buscar");
        String dniBuscar = teclado.nextLine();

        Optional <Cliente> c = listaClientes.stream().filter(cliente -> cliente.getDni().equals(dniBuscar)).findFirst();

        if(c.isPresent()){
            System.out.println(c.get());
        }
        else{
            System.out.println("Cliente no encontrado");
        }
    }
}
