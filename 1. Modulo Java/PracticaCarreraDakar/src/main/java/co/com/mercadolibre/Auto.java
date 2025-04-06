package co.com.mercadolibre;

public class Auto extends Vehiculo{

    public Auto() {
    }

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion,1000, anguloDeGiro, patente, 4);
    }

    
}
