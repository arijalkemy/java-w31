package com.mercadoLibre;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<Producto>();
        double precioFinal = 0;

        productos.add(new Perecedero("Yogur", 2.50, 1));
        productos.add(new Perecedero("Leche", 1.50, 2));
        productos.add(new NoPerecedero("Arroz", 3.00, "Grano"));
        productos.add(new NoPerecedero("Aceite", 5.00, "Cocina"));

        for (Producto producto : productos) {
            precioFinal += producto.calcular(5);
        }

        System.out.println("El precio final al vender " + productos.size() + " productos es $" + precioFinal);

    }
}
