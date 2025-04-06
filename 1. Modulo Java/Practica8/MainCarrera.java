package Practica8;

public class MainCarrera {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(100000, 5000, "Daytona USA", 10);

        carrera.darDeAltaAuto(12000,12000,9000,"FEFD12");
        carrera.darDeAltaMoto(120,120,90,"FEFD13");
        carrera.darDeAltaAuto(120,120,90,"FEFD14");
        carrera.darDeAltaMoto(120,120,90,"FEFD15");
        carrera.darDeAltaAuto(120,120,90,"FEFD16");
        carrera.darDeAltaAuto(120,120,90,"FEFD17");
        carrera.darDeAltaMoto(120000,1200000,90,"FEFD18");
        carrera.darDeAltaAuto(120,120,90,"FEFD19");
        carrera.darDeAltaMoto(120,120,90,"FEFD10");

        System.out.println(carrera.toString());

        Vehiculo auto = new Auto(120,120,90,"FEFD12");
        carrera.eliminarVehiculo(auto);
        carrera.eliminarVehiculoConPatente("FEFD13");

        System.out.println(carrera.toString());

        System.out.println(carrera.calcularGanador());

        carrera.socorrerAuto("FEFD14");

        carrera.socorrerMoto("FEFD15");

    }

}
