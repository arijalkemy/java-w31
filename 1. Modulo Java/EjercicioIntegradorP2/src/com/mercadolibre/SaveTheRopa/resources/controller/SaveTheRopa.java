package com.mercadolibre.SaveTheRopa.resources.controller;

import com.mercadolibre.SaveTheRopa.resources.model.GuardaRopa;
import com.mercadolibre.SaveTheRopa.resources.model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class SaveTheRopa {
    public static void main(String[] args) {
        GuardaRopa<Prenda> guardaRopa = new GuardaRopa<>();

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Nike", "Camiseta") {});
        prendas.add(new Prenda("Adidas", "Pantalón") {});

        Integer codigo = guardaRopa.guardarPrendas(prendas);
        System.out.println("Código de guardado: " + codigo);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(codigo);
        System.out.println("Prendas recuperadas: " + prendasRecuperadas);
    }
}
