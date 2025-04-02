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
        Perecedero perecedero = new Perecedero("Chocorramo",3250D,2);
        Perecedero perecedero2 = new Perecedero("Bom bom bum",500D,3);
        Perecedero perecedero3 = new Perecedero("Detodito",4000D,2);
        Perecedero perecedero4 = new Perecedero("Pony Malta",2000D,2);
        Perecedero perecedero5 = new Perecedero("Coca Cola",2500D,1);
        NoPerecedero noPerecedero1 = new NoPerecedero("Atún van camps",3250D,"Atún");
        NoPerecedero noPerecedero2 = new NoPerecedero("new york steak",50000D,"Carne");
        NoPerecedero noPerecedero3 = new NoPerecedero("Chicharron",10000D,"Cerdo");
        NoPerecedero noPerecedero4 = new NoPerecedero("Pechuga",7500D,"Pollo");
        NoPerecedero noPerecedero5 = new NoPerecedero("Huevo AAA",600D,"Huevo");
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

        perecedero4.calcular(5);
        System.out.println("Total alimento no perecedero: "+noPerecedero4.calcular(5));
    }
}