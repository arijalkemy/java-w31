public class Moto extends Vehiculo {
    public static final double PESO_MOTO = 300;
    public static final int RUEDAS_MOTO = 2;

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_MOTO, RUEDAS_MOTO);
    }
}
