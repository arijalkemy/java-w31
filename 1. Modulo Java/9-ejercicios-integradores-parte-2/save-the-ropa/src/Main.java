import Model.GuardaRopa;
import Model.Prendas.Abrigo;
import Model.Prendas.Prenda;
import Model.Prendas.Remera;
import Model.Prendas.TipoPrenda;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Prenda remeraNike = new Remera("Nike", "Nike Air", 50D, 30D, TipoPrenda.REMERA);
        Prenda abrigoAdidas = new Abrigo("Adidas", "Adidas Pro", false, TipoPrenda.ABRIGO);

        GuardaRopa guardaRopa = new GuardaRopa();

        System.out.println("\nGUARDAR PRENDAS");
        UUID id = guardaRopa.guardarPrendas(List.of(remeraNike, abrigoAdidas));

        System.out.println("\nMOSTRAR PRENDAS DEL GUARDAROPA");
        guardaRopa.mostrarPrendas();

        System.out.println("\nRECUPERAR PRENDAS");
        List<Prenda> prendas = guardaRopa.devolverPrendas(id);

        System.out.println("\nMOSTRAR PRENDAS DEL GUARDAROPA");
        guardaRopa.mostrarPrendas();

    }
}