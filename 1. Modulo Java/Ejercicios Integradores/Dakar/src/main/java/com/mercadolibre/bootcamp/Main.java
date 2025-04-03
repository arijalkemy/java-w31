package com.mercadolibre.bootcamp;

import com.mercadolibre.bootcamp.model.Auto;
import com.mercadolibre.bootcamp.model.Carrera;
import com.mercadolibre.bootcamp.model.Moto;
import com.mercadolibre.bootcamp.model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        Carrera carrera = new Carrera(5., 1200., "Carrera MELI", 3);
        carrera.darDeAltaAuto(80., 9.8, 60., "001");
        carrera.darDeAltaAuto(120., 16.9, 75., "002");
        carrera.darDeAltaMoto(100., 12.5, 80., "003");

        System.out.println(carrera.toString());
        System.out.println();
        System.out.println("=== Máxima cantidad de vehiculos ===");
        try {
            carrera.darDeAltaMoto(100., 12.5, 80., "004");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("=== Vehiculo Ganador === ");
        System.out.println(carrera.obtenerVehiculoGanador());
        System.out.println();
        System.out.println("=== Eliminar Vehiculo === ");
        carrera.eliminarVehiculoConPatente("001");
        System.out.println(carrera);
        System.out.println("==== Socorrista Moto ====");
        carrera.socorrerMoto("003");
        System.out.println();
        System.out.println("==== Socorrista Auto ====");
        carrera.socorrerAuto("002");

    }
}