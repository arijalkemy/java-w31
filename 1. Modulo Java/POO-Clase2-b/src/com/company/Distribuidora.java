package com.company;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

	    List<Producto> arr = new ArrayList<Producto>();

	    //Agregar 5 productos perecederos
        arr.add(new Perecedero(1,"Carne",12000.0));
        arr.add(new Perecedero(2,"Leche",1900.0));
        arr.add(new Perecedero(3,"Yogurt",3500.0));
        arr.add(new Perecedero(2,"Queso",2450.0));
        arr.add(new Perecedero(3,"Hamburguesas",2500.0));

        //Agregar 5 productos no perecededores
        arr.add(new NoPerecedero("No Perecedero","Harina",999.0));
        arr.add(new NoPerecedero("No Perecedero","Arroz",1999.0));
        arr.add(new NoPerecedero("No Perecedero","Fedeo",2500.0));
        arr.add(new NoPerecedero("No Perecedero","Aceite",5500.0));
        arr.add(new NoPerecedero("No Perecedero","Durazno en Lata",1900.0));

        //Imprimir el precio al vender 5 productos de cada tipo
        for (Producto p : arr) {
            double precioTotal = p.calcular(5);
            System.out.println("Precio total por 5 unidades de " + p.getNombre() + ": $" + precioTotal);
        }
    }
}
