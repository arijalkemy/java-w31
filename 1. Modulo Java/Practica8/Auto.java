package Practica8;

public class Auto extends Vehiculo{

    public Auto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente, 1000, 4);
    }

    @Override
    public String toString() {
        return "Auto{}" + super.toString();
    }
}
