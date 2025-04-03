package com.mercadolibre;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String []args){
        GuardaRopa guardarropa = new GuardaRopa();

        List<Prenda> prendas = Arrays.asList(new Prenda("Nike", "Tiempo"),
                                    new Prenda("Adidas", "Tiempo"));

        guardarropa.guardarPrendas(prendas);
        guardarropa.mostrarPrendas();
        guardarropa.devolverPrendas(1);
        }
    }

