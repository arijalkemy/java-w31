package org.meli;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Distribuidora.obtenerProductos();

        int cantidadDeProductos = 1;
        double total = 0.0;

        for (Producto producto : productos) {
            double precio = producto.calcular(cantidadDeProductos);
            System.out.println(producto);
            System.out.println("Precio total por " + cantidadDeProductos + ": $" + precio);
            total += precio;
            System.out.println();
        }
        System.out.println("Precio total de todos los productos: $" + total);
    }
}