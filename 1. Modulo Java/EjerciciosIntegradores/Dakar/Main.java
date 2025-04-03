package EjerciciosIntegradores.Dakar;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera((long) 200, 100.0, "Carrera nueva", (long)10);
        
        Auto auto = new Auto((long) 200, (long) 10, (long) 5, "ABC123", 1000, 4);
        Moto moto = new Moto((long) 150, (long) 20, (long) 3, "XYZ789", 300, 2);
        carrera.darDeAltaAuto(auto.getVelocidad(), auto.getAceleracion(), auto.getAnguloDeGiro(), auto.getPatente());
        carrera.darDeAltaMoto(moto.getVelocidad(), moto.getAceleracion(), moto.getAnguloDeGiro(), moto.getPatente());
        
        System.out.println("Vehículos anotados en la carrera:");
        for (Vehiculo vehiculo : carrera.getVehiculos()) {
            System.out.println("Patente: " + vehiculo.getPatente() + ", Tipo: " + (vehiculo instanceof Auto ? "Auto" : "Moto"));
        }

        System.out.println("Eliminando vehículo con patente ABC123...");
        carrera.eliminarVehiculoConPatente("ABC123");
        System.out.println("Vehículos anotados en la carrera después de eliminar:");
        for (Vehiculo vehiculo : carrera.getVehiculos()) {
            System.out.println("Patente: " + vehiculo.getPatente() + ", Tipo: " + (vehiculo instanceof Auto ? "Auto" : "Moto"));
        }

        carrera.socorrerMoto(moto);
    }
}
