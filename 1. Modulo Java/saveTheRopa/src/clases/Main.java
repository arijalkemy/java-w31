package clases;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardarropa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Levis", "Jean");
        Prenda prenda2 = new Prenda("Rusty", "Remera");
        Prenda prenda3 = new Prenda("Nike", "Jordan");
        Prenda prenda4 = new Prenda("Puma", "Botines");

        List<Prenda> prendas1 = new ArrayList<>();
        prendas1.add(prenda1);
        prendas1.add(prenda2);
        List<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(prenda3);
        prendas2.add(prenda4);

        Integer codigoPrendas1 = guardarropa.guardarPrendas(prendas1);
        guardarropa.guardarPrendas(prendas2);

        List<Prenda> prendasSacadasDelGuardarropa = guardarropa.devolverPrendas(codigoPrendas1);

        for (Prenda p : prendasSacadasDelGuardarropa) {
            System.out.println(p.toString());
        }
        System.out.println("-----------------------------");
        System.out.println("Pruebo el metodo mostrar prendas");
        guardarropa.mostrarPrendas();
    }
}
