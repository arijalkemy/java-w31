package dakar;

public class SocorristaMoto extends Moto {

    public SocorristaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        System.out.println("Socorriendo al vehículo: " + vehiculo.getPatente());
    }
}
