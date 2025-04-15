package com.mercadoLibre;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(5000, 10000, "Gran Premio", 5);

        carrera.darDeAltaAuto(200, 10, 30, "AAA111");
        carrera.darDeAltaMoto(180, 12, 25, "BBB222");
        carrera.darDeAltaAuto(220, 9, 28, "CCC333");
        carrera.darDeAltaMoto(190, 11, 27, "DDD444");

        System.out.println("\nVehículos inscriptos");
        carrera.getParticipantes().forEach(v ->
                System.out.println("Patente: " + v.getPatente() + ", Tipo: " + v.getClass().getSimpleName())
        );

        Vehiculo ganador = carrera.ganador();
        if (ganador != null) {
            System.out.println("\nGanador de la carrera :)");
            System.out.println("Patente: " + ganador.getPatente() + ", Tipo: " + ganador.getClass().getSimpleName());
        } else {
            System.out.println("No hay vehículos en la carrera.");
        }

        System.out.println("\nSocorriendo vehículos!");
        carrera.socorrerAuto("AAA111");
        carrera.socorrerMoto("BBB222");

        carrera.socorrerAuto("ZZZ999");

        System.out.println("\nEliminando vehiculos!");
        carrera.getParticipantes().stream()
                .filter(v -> v.getPatente().equalsIgnoreCase("DDD444"))
                .findFirst().ifPresent(carrera::darDeBaja);

        carrera.darDeBajaConPatente("CCC333");

        System.out.println("\nVehículos después de eliminar patente CCC333");
        carrera.getParticipantes().forEach(v ->
                System.out.println("Patente: " + v.getPatente() + ", Tipo: " + v.getClass().getSimpleName())
        );
    }
}

