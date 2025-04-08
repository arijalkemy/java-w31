package org.meli;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Leche", 25.0, 1));
        productos.add(new Perecedero("Yogur", 15.0, 2));
        productos.add(new Perecedero("Queso", 50.0, 3));
        productos.add(new Perecedero("Frutas", 50.0, 4));
        productos.add(new Perecedero("Pan", 10.0, 5));

        productos.add(new NoPerecedero("Arroz", 20.0, "Grano"));
        productos.add(new NoPerecedero("Lentejas", 25.0, "Legumbre"));
        productos.add(new NoPerecedero("Detergente", 100.0, "Limpieza"));
        productos.add(new NoPerecedero("Aceite", 50.0, "Cocina"));
        productos.add(new NoPerecedero("Sal", 10.0, "Condimento"));

        return productos;
    }

}
