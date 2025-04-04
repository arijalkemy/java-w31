package org.example;
import org.example.models.GuardaRopa;
import org.example.models.Prenda;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Prenda prenda = new Prenda("Arturo Calle", "Buzo");
        Prenda prenda2 = new Prenda("Arturo Calle", "Pantaloneta");

        Prenda prenda3 = new Prenda("Nike", "Jordan 1");
        Prenda prenda4 = new Prenda("Nike", "Air Max");

        List<Prenda> superior = Arrays.asList(prenda, prenda2);
        List<Prenda> zapatos = Arrays.asList(prenda3, prenda4);

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(superior);
        guardaRopa.guardarPrendas(zapatos);
        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(1);
    }
}