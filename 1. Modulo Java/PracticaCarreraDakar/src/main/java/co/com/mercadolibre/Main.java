package co.com.mercadolibre;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(100.0, 10000.0, "Gran Premio", 5, new ArrayList<>());

        carrera.darDeAltaAuto(120, 10, 45, "AUTO1");   // Adding an Auto
        carrera.darDeAltaMoto(100, 12, 30, "MOTO1");     // Adding a Moto
        carrera.darDeAltaAuto(130, 11, 50, "AUTO2");     // Adding another Auto

        System.out.println("Vehículos en la carrera:");
        System.out.println(carrera.getVehiculos());
        System.out.println();

        carrera.socorrerAuto("AUTO1");   
        carrera.socorrerAuto("MOTO1");   
        System.out.println();

        carrera.socorrerMoto("MOTO1");   
        carrera.socorrerMoto("AUTO2");   
        System.out.println();

        Vehiculo ganador = carrera.ganadorDeLaCarrera();
        System.out.println("El ganador de la carrera es:");
        System.out.println(ganador);
        System.out.println();
        
        carrera.eliminarVehiculoConPatente("AUTO2");
        System.out.println("Vehículos en la carrera después de eliminar AUTO2:");
        System.out.println(carrera.getVehiculos());
    }
}