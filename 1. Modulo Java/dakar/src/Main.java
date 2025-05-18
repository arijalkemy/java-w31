public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(5000.0, 10000.0, "Gran Premio", 5);

        carrera.darDeAltaAuto(200.0, 10.0, 30.0, "AAA111");
        carrera.darDeAltaMoto(180.0, 12.0, 25.0, "BBB222");
        carrera.darDeAltaAuto(220.0, 9.0, 28.0, "CCC333");
        carrera.darDeAltaMoto(190.0, 11.0, 27.0, "DDD444");

        System.out.println("\nVehículos inscriptos");
        carrera.getVehiculoList().forEach(v ->
                System.out.println("Patente: " + v.getPatente() + ", Tipo: " + v.getClass().getSimpleName())
        );

        Vehiculo ganador = carrera.ganador();
        if (ganador != null) {
            System.out.println("\nGanador de la carrera");
            System.out.println("Patente: " + ganador.getPatente() + ", Tipo: " + ganador.getClass().getSimpleName());
        } else {
            System.out.println("No hay vehículos en la carrera.");
        }

        System.out.println("\nSocorriendo vehículos");
        carrera.socorrerAuto("AAA111");
        carrera.socorrerMoto("BBB222");

        carrera.socorrerAuto("ZZZ999");

        System.out.println("\nEliminando vehiculos");
        carrera.eliminarVehiculoConPatente("CCC333");

        System.out.println("\nVehículos después de eliminar patente CCC333");
        carrera.getVehiculoList().forEach(v ->
                System.out.println("Patente: " + v.getPatente() + ", Tipo: " + v.getClass().getSimpleName())
        );
    }
}