package Practica5;

import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {


        System.out.println("BUENOS DIAS AL BANCO");
        System.out.println("SELECCIONE SU PERFIL");
        System.out.println("1- Ejecutivo");
        System.out.println("2- Basic");
        System.out.println("3- Cobrador");

        Scanner scanner = new Scanner(System.in);
        String seleccion = scanner.next();

        Cliente cliente = new Ejecutiv("PEDRO", 01);

        if(seleccion.equals("1")){
            cliente = new Ejecutiv("PEDRO", 01);
        }
        if(seleccion.equals("2")){
            cliente = new Basic("PEDRO", 01);
        }
        if(seleccion.equals("3")){
            cliente = new Cobrador("PEDRO", 01);

        }

        cliente.realizarOperacion();




    }


}
