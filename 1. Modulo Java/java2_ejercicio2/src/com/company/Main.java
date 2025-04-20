package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        double precioTotal = 0;
        List<Producto> productos = new ArrayList<Producto>();

        productos.add(new Perecedero("Leche", 2000, 1));
        productos.add(new NoPerecedero("Fideos",2000,"Pasta"));
        productos.add(new NoPerecedero("Arroz", 1500, "Pasta"));
        productos.add(new Perecedero("Huevos", 8000, 2));
        productos.add(new NoPerecedero("Harina", 3000, "Trigo"));
        productos.add(new Perecedero("Tomates", 2500, 1));
        productos.add(new Perecedero("Carne", 9000, 1));
        productos.add(new Perecedero("Pan", 2000, 3));
        productos.add(new NoPerecedero("Aceite", 4500, "Girasol"));
        productos.add(new NoPerecedero("Atun en lata", 4000, "Pescado"));


        for( Producto producto : productos) {
            System.out.println(producto.toString());
            precioTotal += producto.calcular(1);
        }
        System.out.println("El precio total es: " + precioTotal);
    }
}
