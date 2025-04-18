package org.example;

import org.example.GuardaRopa;
import org.example.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendasDeJuan = new ArrayList<>();
        prendasDeJuan.add(new Prenda("Nike", "Campera"));
        prendasDeJuan.add(new Prenda("Adidas", "Buzo"));

        Integer codigo = guardaRopa.guardarPrendas(prendasDeJuan);
        System.out.println("Código entregado: " + codigo);

        System.out.println("\nPrendas guardadas actualmente:");
        guardaRopa.mostrarPrendas();

        System.out.println("\nJuan retira sus prendas con el código " + codigo);
        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(codigo);

        System.out.println("Prendas devueltas:");
        for (Prenda prenda : prendasDevueltas) {
            System.out.println(prenda);
        }

        System.out.println("\nEstado del guardarropas luego de la devolución:");
        guardaRopa.mostrarPrendas();
    }
}
