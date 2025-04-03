package ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Queso", 8000.00, 5));
        productos.add(new NoPerecedero("Arroz", 4000.00, "Grano"));

        double total = productos.stream().mapToDouble(p -> p.calcular(5)).sum();
        System.out.println("total = " + total);
    }

}
