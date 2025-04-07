public class Auto extends Vehiculo {
    public static final double PESO_AUTO = 1000;
    public static final int RUEDAS_AUTO = 4;

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_AUTO, RUEDAS_AUTO);
    }
}