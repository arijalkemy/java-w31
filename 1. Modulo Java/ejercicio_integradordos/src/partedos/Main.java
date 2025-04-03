package partedos;

import partedos.modelos.Carrera;
import partedos.modelos.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500, 10000, "Gran Prix", 5);

        carrera.darDeAltaAuto(200, 5, 30, "ABC123");
        carrera.darDeAltaMoto(150, 6, 40, "XYZ789");


        Vehiculo ganador = carrera.definirGanador();
        if (ganador != null) {
            System.out.println("El ganador es el vehículo con patente: " + ganador.getPatente());
        } else {
            System.out.println("No hay vehículos para determinar un ganador.");
        }

        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("XYZ789");

        carrera.darDeAltaAuto(220, 5, 25, "LMN456");
        carrera.darDeAltaMoto(180, 7, 35, "OPQ123");

    }
}
