package com.mercadolibre.modulojava.poopartetres;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Distribuidora {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Perecedero("Carne de res",50000D,3));
        productos.add(new Noperecedero("atun",15000D,"peces"));
        for (Producto producto : productos) {
            System.out.println(producto.calcular(5));;
        }






        }
    }
