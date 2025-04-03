package saveThePrendas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopas<Prenda> g = new GuardaRopas<>();
        List<Prenda> prendas = new ArrayList<>();
        Prenda p1 = new Prenda("Remera", "Adidas");
        Prenda p2 = new Prenda("Pantalon", "Nike");
        prendas.add(p1);
        prendas.add(p2);
        int id_guardado = g.guardarPrendas(prendas);
        g.mostrarPrendas();
        System.out.println("------------------------------");
        g.guardarPrendas(prendas);
        g.mostrarPrendas();
        System.out.println("------------------------------");
        List<Prenda> recuperadas = g.devolverPrendas(id_guardado);
        System.out.println(recuperadas);
        System.out.println("------------------------------");
        g.mostrarPrendas();
    }
}
