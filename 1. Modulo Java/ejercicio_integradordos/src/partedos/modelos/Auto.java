package partedos.modelos;

public class Auto extends Vehiculo {
    private static final double PESO = 1000.0;
    private static final int RUEDAS = 4;

    public Auto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, PESO, RUEDAS);
    }
}
