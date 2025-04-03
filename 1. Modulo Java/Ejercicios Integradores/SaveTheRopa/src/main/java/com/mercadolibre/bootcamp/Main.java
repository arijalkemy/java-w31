package com.mercadolibre.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        Prenda camiseta = new Prenda("Camiseta", "H&M");
        Prenda pantalon  = new Prenda("Pantalon", "Koaj");
        Prenda shorts = new Prenda("Shorts", "Adidas");

        prendas.add(camiseta);
        prendas.add(pantalon);
        prendas.add(shorts);

        Integer codigo = guardaRopa.guardarPrendas(prendas);
        System.out.println("Código asignado: " + codigo);

        System.out.println("=== Consultando por Código ===");
        guardaRopa.mostrarPrendas();

    }
}