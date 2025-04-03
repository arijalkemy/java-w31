package EjerciciosIntegradores.Dakar;

public class SocorristaAuto extends Socorrista {
    
    @Override
    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof Auto) {
            System.out.println("Socorriendo a un auto con patente: " + vehiculo.getPatente());
        } else {
            System.out.println("No se puede socorrer a un vehiculo que no es un auto.");
        }
    }
}
