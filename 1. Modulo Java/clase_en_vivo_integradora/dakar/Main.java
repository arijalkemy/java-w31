package dakar;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000, 10000, "Dakar", 5);
        carrera.darDeAltaAuto(200, 10, 30, "ABC123", "Toyota", "Hilux");
        carrera.darDeAltaAuto(300, 10, 20, "DEF635", "Toyota", "Etios");

        carrera.mostrarGanador();
        carrera.darDeAltaMoto(150, 15, 25, "XYZ789");
        carrera.darDeAltaMoto(250, 15, 25, "AAA780");

        carrera.mostrarGanador();
        carrera.eliminarVehiculoConPatente("ABC123");
        carrera.mostrarGanador();
    }
}
