package com.mercadolibre.modulojava.ejerciciointegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Cliente> clienteList= new ArrayList<>();
        clienteList.add(new Cliente("Jose","Ramirez","1231983218"));
        clienteList.add(new Cliente("Diego","Monserrat","423423498394"));
        clienteList.add(new Cliente("Sara","Ramirez","2342342344234"));
        System.out.println(clienteList);
        clienteList.removeFirst();
        System.out.println(clienteList);
        Scanner y = new Scanner(System.in);
        System.out.println("Digite el dni del cliente: ");
        String dni = y.nextLine();
        clienteList.stream().filter(x->x.getDni().equals(dni)).findFirst().ifPresentOrElse(System.out::println,()-> System.out.println("El cliente no se encuentra registrado"));
    }
}