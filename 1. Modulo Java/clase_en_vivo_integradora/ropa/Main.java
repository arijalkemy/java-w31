package ropa;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Gucci", "Campera cuero", 1);
        Prenda prenda2 = new Prenda("Kevingston", "Chomba", 2);
        Prenda prenda3 = new Prenda("Levis", "Pantalon negro", 3);

        guardaRopa.guardarPrendas(List.of(prenda1, prenda2, prenda3));

        guardaRopa.mostrarPrendas();

        List<Prenda> prendaDevuelta = guardaRopa.devolverPrendas(2);
        System.out.println("Prenda devuelta: ");
        prendaDevuelta.forEach(p -> System.out.println(p.getId() + " : " + p.getMarca() + " " + p.getModelo()));
    }
}
