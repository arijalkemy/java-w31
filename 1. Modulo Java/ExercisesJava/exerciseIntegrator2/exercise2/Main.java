package exerciseIntegrator2.exercise2;

import java.util.ArrayList;

import exerciseIntegrator2.exercise2.clases.Carrera;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(5000D, 4500D, "Carrera contra el tiempo", 5, new ArrayList<>());
        carrera.darDeAltaAuto(80., 9.8, 60., "001");
        carrera.darDeAltaAuto(120., 16.9, 75., "002");
        carrera.darDeAltaMoto(100., 12.5, 80., "003");

        System.out.println(carrera.toString());
        System.out.println();
        System.out.println("=== Máxima cantidad de vehiculos === " + carrera.getCantidadDeVehiculosPermitidos());

        carrera.eliminarVehiculoConPatente("001");
        System.out.println(carrera.toString());
    }
}
