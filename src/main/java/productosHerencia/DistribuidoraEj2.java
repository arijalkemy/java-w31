package productosHerencia;

import java.util.ArrayList;

public class DistribuidoraEj2 {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int precio = (int) (Math.random() * 100);
            int diasPorCaducar = (int) (Math.random() * 5);
            Producto perecedero = new Perecedero("Perecedero", precio, diasPorCaducar);
            productos.add(perecedero);
        }

        for (int i = 0; i < 5; i++) {
            int precio = (int) (Math.random() * 100);
            Producto noPerecedro = new NoPerecedero("NoPerecedero", precio);
            productos.add(noPerecedro);
        }

        for (int i = 0; i < 5; i++) {
            int precio = (int) (Math.random() * 100);
            Producto producto = new Producto("Producto", precio);
            productos.add(producto);
        }

        double total = productos.stream().map(Producto::getPrecio).reduce(0.0, Double::sum);
        System.out.println("El total es: " + total);
    }
}
