package Practica4;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new NoPerecedero(2000, "yogurt", "lacteo"));
        productos.add(new Perecedero(3000, "arroz", 2));
        productos.add(new Producto(3000, "LECHE"));
        productos.add(new NoPerecedero(1000, "ALFAJOR", "lacteo"));
        productos.add(new Perecedero(3000, "fideos", 3));

        for (Producto producto : productos){
            producto.calcular(2);
            System.out.println(producto.toString());
        }
    }
}




