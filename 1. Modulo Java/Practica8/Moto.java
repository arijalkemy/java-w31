package Practica8;

public class Moto extends Vehiculo{
    public Moto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente, 300, 2);
    }

    @Override
    public String toString() {
        return   "Moto{}" + super.toString();
    }
}
