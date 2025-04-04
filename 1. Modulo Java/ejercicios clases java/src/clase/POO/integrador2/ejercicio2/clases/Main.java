package clase.POO.integrador2.ejercicio2.clases;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocorristaAuto socAuto = new SocorristaAuto(50D, 10D, 30D, "soc123");
        SocorristaMoto socMoto = new SocorristaMoto(50D, 10D, 30D, "soc321");

        Carrera carrera = new Carrera(100D, 10000D, "Dakar", 5, socAuto, socMoto);
        carrera.darDeAltaAuto(100D, 15D, 45D, "abc123");
        carrera.darDeAltaAuto(90D, 20D, 55D, "lco452");
        carrera.darDeAltaAuto(85D, 30D, 45D, "vdw231");
        carrera.darDeAltaMoto(85D, 30D, 45D, "vdw231");
        carrera.darDeAltaMoto(130D, 10D, 20D, "lkj098");
        carrera.darDeAltaMoto(90D, 25D, 50D, "jhg697");

        Vehiculo ganador = carrera.definirGanador();

        System.out.println("El ganador es el carro con caracteristicas: ");
        System.out.println(ganador.toString());


    }
}
