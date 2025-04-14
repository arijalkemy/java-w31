package com.mercadoLibre;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas1 = Arrays.asList(
                new Prenda("Pull&Bear", "Camisa"),
                new Prenda("Zara", "Pantalón")
        );

        List<Prenda> prendas2 = Arrays.asList(
                new Prenda("Stradivarius", "Vestido"),
                new Prenda("Mango", "Falda")
        );

        List<Prenda> prendas3 = Arrays.asList(
                new Prenda("H&M", "Remera"),
                new Prenda("Zara", "Campera")
        );

        Integer codigo1 = guardaRopa.guardarPrendas(prendas1);
        Integer codigo2 = guardaRopa.guardarPrendas(prendas2);
        Integer codigo3 = guardaRopa.guardarPrendas(prendas3);

        System.out.println("\nCódigo asignado: " + codigo1);
        System.out.println("\nCódigo asignado: " + codigo2);
        System.out.println("\nCódigo asignado: " + codigo3);

        System.out.println("\nPrendas guardadas bajo el código " + codigo1 + ":");
        guardaRopa.devolverPrendas(codigo1).forEach(System.out::println);

        System.out.println("\nPrendas guardadas bajo el código " + codigo2 + ":");
        guardaRopa.devolverPrendas(codigo2).forEach(System.out::println);

        System.out.println("\nPrendas guardadas bajo el código " + codigo3 + ":");
        guardaRopa.devolverPrendas(codigo3).forEach(System.out::println);

        System.out.println("\nTodas las prendas en el guardarropas");
        guardaRopa.mostrarPrendas();
    }

}
