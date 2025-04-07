import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        // Crear prendas
        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");

        List<Prenda> listaDePrenda = new ArrayList<>();
        listaDePrenda.add(prenda1);
        listaDePrenda.add(prenda2);

        // Guardar prendas y recibir código
        Integer codigo = guardaRopa.guardarPrendas(listaDePrenda);
        System.out.println("Prendas guardadas con el código: " + codigo);

        // Mostrar las prendas almacenadas
        guardaRopa.mostrarPrendas();

        // Devolver prendas usando el código
        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(codigo);
        System.out.println("Prendas devueltas: " + prendasDevueltas);

        // Mostrar el estado actual del guarda-ropa
        guardaRopa.mostrarPrendas();
    }
}