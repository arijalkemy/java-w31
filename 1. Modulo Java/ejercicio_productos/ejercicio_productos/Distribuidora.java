package ejercicio_productos;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Leche", 1.5, 3));
        productos.add(new Perecedero("Yogurt", 2.0, 5));
        productos.add(new NoPerecedero("Arroz", 1.2, "Alimento básico"));
        productos.add(new NoPerecedero("Lata de atún", 2.5, "Conserva"));
        productos.add(new Producto("Pan", 1.0));
        productos.add(new Producto("Jugo", 1.8));
        productos.add(new Producto("Galletas", 2.2));

        for (Producto producto : productos) {
            System.out.println(producto.toString());
            System.out.println("Precio total por 5 productos: " + producto.calcular(5));
        }
    }
}
