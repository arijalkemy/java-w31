package dev.michellarias;

import java.util.ArrayList;
import java.util.List;

public class SaveTheRopaMain {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Arturo Calle", "Manga Corta"));
        prendas.add(new Prenda("Michael Kors", "Chaqueta Verano"));
        prendas.add(new Prenda("Gucci", "Vaqueros Invierno"));

        int id = guardaRopa.guardarPrendas(prendas);
        System.out.printf("ID Generado: %d \n", id);

        System.out.println("------ PRENDAS ------");
        List<Prenda> prendasPorId = guardaRopa.devolverPrendas(id);
        prendasPorId.forEach(System.out::println);

        guardaRopa.mostrarPrendas();
    }
}
