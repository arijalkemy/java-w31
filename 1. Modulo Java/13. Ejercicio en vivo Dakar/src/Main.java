public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000, 50000, "Gran Premio", 5);

        carrera.darDeAltaAuto(150, 10, 30, "ABC123");
        carrera.darDeAltaAuto(160, 9, 29, "DEF456");
        carrera.darDeAltaMoto(180, 8, 20, "GHI789");
        carrera.darDeAltaMoto(170, 11, 25, "JKL010");

        Vehiculo ganador = carrera.definirGanador();
        System.out.println("El ganador es el vehículo con patente: " + ganador.getPatente());

        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("GHI789");

        carrera.eliminarVehiculoConPatente("DEF456");

        // Mostrar los demás vehículos sobrantes
        viagem();
    }
}