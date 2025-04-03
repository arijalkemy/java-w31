package partedos.modelos;

public class Moto extends Vehiculo {
    private static final double PESO = 300;
    private static final int RUEDAS = 2;

    public Moto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, PESO, RUEDAS);
    }
}
