package org.example;

import org.example.models.ejerciciodos.Distribuidora;
import org.example.models.ejerciciodos.NoPerecedero;
import org.example.models.ejerciciodos.Perecedero;
import org.example.models.ejerciciodos.Producto;
import org.example.models.ejerciciouno.PracticaExcepciones;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //EJERCICIO 1 -----------------------------------------------------------------

        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
/*
        try{
            practicaExcepciones.calcularCociente();
        }catch(Exception e){
            //System.out.println("Se ha producido un error.");
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }finally{
            System.out.println("Programa finalizado.");
        }
*/

        //EJERCICIO 2 ---------------------------------------------------------------

        Distribuidora distribuidora = new Distribuidora();
        Perecedero perecedero = new Perecedero("Carne",3250D,2);
        Perecedero perecedero2 = new Perecedero("Pescado",500D,3);
        Perecedero perecedero3 = new Perecedero("Pechuga",4000D,2);
        Perecedero perecedero4 = new Perecedero("Huevo",2000D,2);
        Perecedero perecedero5 = new Perecedero("Piña",2500D,1);
        NoPerecedero noPerecedero1 = new NoPerecedero("Arroz",3250D,"Granos");
        NoPerecedero noPerecedero2 = new NoPerecedero("Lenteja",50000D,"Granos");
        NoPerecedero noPerecedero3 = new NoPerecedero("Frijol",10000D,"Granos");
        NoPerecedero noPerecedero4 = new NoPerecedero("Sal",7500D,"Condimentos");
        NoPerecedero noPerecedero5 = new NoPerecedero("Azucar",600D,"Condimentos");
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(perecedero);
        productos.add(perecedero2);
        productos.add(perecedero3);
        productos.add(perecedero4);
        productos.add(perecedero5);
        productos.add(noPerecedero1);
        productos.add(noPerecedero2);
        productos.add(noPerecedero3);
        productos.add(noPerecedero4);
        productos.add(noPerecedero5);
        distribuidora.setProductos(productos);

        double total = distribuidora.getProductos()
                .stream()
                .mapToDouble(producto -> producto.calcular(5))
                .sum();

        System.out.println("Precio total: "+total);
    }
}