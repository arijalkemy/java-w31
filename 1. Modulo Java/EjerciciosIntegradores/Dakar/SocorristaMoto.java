package EjerciciosIntegradores.Dakar;

public class SocorristaMoto extends Socorrista {
    @Override

    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) {
            System.out.println("Socorriendo a una moto con patente: " + vehiculo.getPatente());
        } else {
            System.out.println("No se puede socorrer a un vehiculo que no es una moto.");
        }
    }
}
