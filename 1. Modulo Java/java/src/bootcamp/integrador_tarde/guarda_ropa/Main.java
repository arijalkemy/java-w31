package bootcamp.integrador_tarde.guarda_ropa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Nike", "Air Max");
        Prenda prenda2 = new Prenda("Adidas", "Ultra Boost");
        Prenda prenda3 = new Prenda("Puma", "RS-X");
        System.out.println( guardaRopa.guardarPrendas(List.of(prenda1, prenda2)));
        System.out.println( guardaRopa.guardarPrendas(List.of(prenda3)));
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(0));
        System.out.println(guardaRopa.devolverPrendas(1));

    }
}
