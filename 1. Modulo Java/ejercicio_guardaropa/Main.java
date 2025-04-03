package ejercicio_guardaropa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda camisa = new Prenda("Tommy", "2025");
        Prenda jean = new Prenda("Jean", "2024");
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(camisa);
        prendas.add(jean);
        GuardaRopa roper = new GuardaRopa();
        Integer identificador = roper.guardarPrendas(prendas);
        System.out.println(identificador);
        System.out.println(roper.devolverPrendas(identificador));
        roper.mostrarPrendas();
    }
}
