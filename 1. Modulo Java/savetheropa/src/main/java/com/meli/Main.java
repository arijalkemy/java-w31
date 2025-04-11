package com.meli;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Agrego prendas
        Prenda prenda1 = new Prenda("Nike", "Pantalon");
        Prenda prenda2 = new Prenda("Adidas", "Remera");

        // creo una lista con prendas1 y prendas2
        List<Prenda> prendas= List.of(prenda1, prenda2); 
        Guardaropa guardaropa = new Guardaropa();

        //Agrego prendas al guardaropa
        guardaropa.guardarPrendas(prendas);
        guardaropa.mostrarPredas();

;

    }
}