import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Zara", "Saco"));
        prendas.add(new Prenda("Portsaid", "Campera de cuero"));

        Integer identificador = guardaRopa.guardarPrendas(prendas);

        guardaRopa.mostrarPrendas();

        if ((guardaRopa.devolverPrendas(identificador)) == null) {
            System.out.println("No hay prendas guardadas bajo ese identificador");
        }

        guardaRopa.mostrarPrendas();

    }
}
