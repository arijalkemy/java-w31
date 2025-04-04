package ejercicio_dakar;

public class Main {
    public static void main(String[] args) {
        // Crear una carrera
        Carrera carrera = new Carrera(1000.0, 50000.0, "Dakar", 5);

        // Crear vehiculos
        carrera.darDeAltaAuto(100.0, 5.4, 30.0, "ABC123");
        carrera.darDeAltaAuto(120.0, 5.0, 25.0, "DEF456");
        carrera.darDeAltaMoto(80.0, 4.0, 20.0, "GHI789");
        carrera.darDeAltaMoto(90.0, 4.5, 22.0, "JKL012");
        carrera.darDeAltaAuto(70.0, 6.0, 15.0, "MNO345");
        carrera.darDeAltaAuto(75.0, 6.5, 18.0, "PQR678");

        System.out.println("Vehiculos en la carrera:");
        System.out.println(carrera.getListaDeVehiculos());

        // Eliminar un vehiculo
        carrera.eliminarVehiculoConPatente("ABC123");
        System.out.println("Vehiculos en la carrera después de eliminar uno:");
        System.out.println(carrera.getListaDeVehiculos());

        // Socorrer a un vehiculo
        carrera.socorrerAuto("DEF456");
        carrera.socorrerMoto("GHI789");

        // Obtener el ganador
        Vehiculo ganador = carrera.getGanador();
        System.out.println("El ganador es: " + ganador.getPatente());
    }
}
