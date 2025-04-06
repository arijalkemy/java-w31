package guardarropa;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guardarropa guardarropa = new Guardarropa();

        List<Prenda> prendas = Arrays.asList(new Prenda("Nike", "Tiempo"), new Prenda("Adidas", "Predator"));

        Integer codigo = guardarropa.guardarPrendas(prendas);

        List<Prenda> prendasSacadasDelGuardarropa = guardarropa.devolverPrendas(codigo);

        for (Prenda p : prendasSacadasDelGuardarropa) {
            System.out.println(p.toString());
        }
    }
}
