package com.mercadolibre.bootcamp;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.bootcamp.model.NoPerecedero;
import com.mercadolibre.bootcamp.model.Perecedero;
import com.mercadolibre.bootcamp.model.Producto;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Silla", 30000D));
        productos.add(new Perecedero("Leche", 6500D, 3));
        productos.add(new Perecedero("Manzana", 2000D, 1));
        productos.add(new NoPerecedero("Colchon", 75800.5, "Inflable"));
        productos.add(new NoPerecedero("Portatil", 4000000D, "Tecnología"));
        int cantidadDeProductos = 5;
        for(Producto producto: productos){
            System.out.println(producto.getNombre() +  ": Precio de " + cantidadDeProductos  + " = " + producto.calcular(cantidadDeProductos));
        }
    }
}