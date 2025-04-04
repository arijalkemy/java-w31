package dakar;

public class Main {

    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000, 50000, "Dakar Race", 5);
        Auto autoA = new Auto(150, 10, 1, "AutoA");
        Auto autoB = new Auto(160, 12, 2, "AutoB");
        Moto motoA = new Moto(120, 8, 1, "MotoA");
        Moto motoB = new Moto(130, 9, 2, "MotoB");

        carrera.darDeAltaAuto(autoA);
        carrera.darDeAltaAuto(autoB);
        carrera.darDeAltaMoto(motoA);
        carrera.darDeAltaMoto(motoB);

        carrera.eliminarVehiculo(autoB);
        carrera.eliminarVehiculo(motoA);

        System.out.println("Ganador de la carrera: " + carrera.ganadorDeLaCarrera().getPatente());
    }
}
