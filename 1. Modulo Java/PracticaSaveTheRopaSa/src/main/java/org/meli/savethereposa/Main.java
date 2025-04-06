package org.meli.savethereposa;

import org.meli.savethereposa.adapters.GuardaRopaImpl;
import org.meli.savethereposa.domain.GuardaRopa;
import org.meli.savethereposa.domain.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Adidas", "Camiseta");
        Prenda prenda2 = new Prenda("Nike", "Chaqueta");

        List<Prenda> listaPrendas1 = new ArrayList<>();
        listaPrendas1.add(prenda1);

        List<Prenda> listaPrendas2 = new ArrayList<>();
        listaPrendas2.add(prenda2);

        GuardaRopa guardaRopa = new GuardaRopa();
        GuardaRopaImpl guardaRopaImpl = new GuardaRopaImpl(guardaRopa);

        Integer clave1 = guardaRopaImpl.guardarPrenda(listaPrendas1);
        Integer clave2 = guardaRopaImpl.guardarPrenda(listaPrendas2);

        System.out.println("Prendas guardadas con claves: " + clave1 + " y " + clave2);

        System.out.println("\nMostrando todas las prendas:");
        guardaRopaImpl.mostrarPrendas();

        System.out.println("\nRecuperando prendas para la clave: " + clave1);
        List<Prenda> prendasPorClave = guardaRopaImpl.devolverPrendas(clave1);
        prendasPorClave.forEach(prenda -> System.out.println(prenda));

        Integer claveInexistente = 99;
        System.out.println("\nRecuperando prendas para la clave inexistente: " + claveInexistente);
        List<Prenda> prendasClaveInexistente = guardaRopaImpl.devolverPrendas(claveInexistente);
        if (prendasClaveInexistente.isEmpty()) {
            System.out.println("No se encontraron prendas para la clave: " + claveInexistente);
        }
    }
}