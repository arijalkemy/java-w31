package org.saveTheRopa;

import org.saveTheRopa.clases.GuardaRopa;
import org.saveTheRopa.clases.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuardaRopa<Prenda> guardaRopa = new GuardaRopa<>();
        List<Prenda> prendaList = new ArrayList<>();
        Prenda p1 = new Prenda("Marca", "Modelo");
        Prenda p2 = new Prenda("Marca2", "Modelo2");

        List<Prenda> prendaList2 = new ArrayList<>();

        prendaList.add(p1);
        prendaList.add(p2);
        prendaList.add(p2);

        prendaList2.add(p1);
        prendaList2.add(p2);

        guardaRopa.guardarPrendas(prendaList);
        guardaRopa.guardarPrendas(prendaList2);

        guardaRopa.mostrarPrendas();

        System.out.println("-----------------------------");
        List<Prenda> prend = guardaRopa.devolverPrendas(1);
        System.out.println(prend);

        System.out.println("-----------------------------");

        List<Prenda> prendaList3 = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Prenda prenda;

        while(true) {
            System.out.println("Introduzca el marca de prenda: (o salir para terminar)");
            String marca = scanner.nextLine();

            if(marca.equals("salir")){
                break;
            }

            System.out.println("Introduzca el modelo de prenda: ");
            String modelo = scanner.nextLine();

            prenda = new Prenda(marca, modelo);
            prendaList3.add(prenda);
        }

        guardaRopa.guardarPrendas(prendaList3);
        guardaRopa.mostrarPrendas();
    }
}