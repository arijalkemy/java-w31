package bootcamp.poo.practica;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Perecedero producto = new Perecedero("Leche", 100, 1);
        System.out.println(producto.calcular(4));
        System.out.println(producto.toString());

        Producto[] productos = new Producto[]{
                new Perecedero("Perecedero1", 10.0, 3),
                new Perecedero("Perecedero2", 20.0, 2),
                new Perecedero("Perecedero3", 30.0, 1),
                new Perecedero("Perecedero4", 40.0, 2),
                new Perecedero("Perecedero5", 50.0, 3),
                new NoPerecedero("NoPerecedero1", 15.0, "Tipo1"),
                new NoPerecedero("NoPerecedero2", 25.0, "Tipo2"),
                new NoPerecedero("NoPerecedero3", 35.0, "Tipo3"),
                new NoPerecedero("NoPerecedero4", 45.0, "Tipo4"),
                new NoPerecedero("NoPerecedero5", 55.0, "Tipo5")
        };

        Distribuidora distribuidora = new Distribuidora(List.of(productos));
        System.out.println("Total: " + distribuidora.calcular());
    }
}
