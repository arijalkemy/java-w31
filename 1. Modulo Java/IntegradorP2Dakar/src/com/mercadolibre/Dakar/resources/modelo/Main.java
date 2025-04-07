package com.mercadolibre.Dakar.resources.modelo;

public class Main {
    public static void main(String[] args) {
        // Crear una carrera
        Carrera<Vehiculo> carrera = new Carrera<>(500, 10000, "Gran Premio", 5);

        // Dar de alta algunos autos y motos
        carrera.darDeAltaVehiculo(new Auto(120, 10, 30, "ABC123"));
        carrera.darDeAltaVehiculo(new Auto(150, 12, 25, "DEF456"));
        carrera.darDeAltaVehiculo(new Moto(100, 15, 20, "GHI789"));
        carrera.darDeAltaVehiculo(new Moto(110, 14, 22, "JKL012"));

        // Eliminar un vehículo por patente
        carrera.eliminarVehiculoConPatente("DEF456");

        // Definir el ganador de la carrera
        Vehiculo ganador = carrera.definirGanador();
        if (ganador != null) {
            System.out.println("El ganador es el vehículo con patente: " + ganador.getPatente());
        } else {
            System.out.println("No hay vehículos en la carrera.");
        }

        // Socorrer un auto
        carrera.socorrerAuto("ABC123");

        // Socorrer una moto
        carrera.socorrerMoto("GHI789");
    }
}