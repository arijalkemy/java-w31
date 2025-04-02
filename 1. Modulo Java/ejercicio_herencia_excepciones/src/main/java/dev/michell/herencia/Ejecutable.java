package dev.michell.herencia;

import java.util.ArrayList;

public class Ejecutable {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        // Perecederos
        Producto papa = new Perecedero("Papa", 3000, 2);
        Producto manzana = new Perecedero("Manzana", 5000, 3);

        // No Perecederos
        Producto atun = new NoPerecedero("Atun", 5000, "Enlatado");
        Producto arroz = new NoPerecedero("Arroz", 3000, "Grano");

        productos.add(papa);
        productos.add(manzana);
        productos.add(atun);
        productos.add(arroz);

        //
        double totalProductos = productos
                .stream()
                .mapToDouble(((p) -> p.calcular(2)))
                .sum();

        System.out.println("Total de Productos: " + totalProductos);
    }
}
