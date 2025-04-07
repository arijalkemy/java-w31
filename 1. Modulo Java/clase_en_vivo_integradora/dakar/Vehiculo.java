package dakar;

public class Vehiculo {
    private int velocidad;
    private int aceleracion;
    private int angulodeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(int velocidad, int aceleracion, int angulodeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.angulodeGiro = angulodeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }
    public int getAceleracion() {
        return aceleracion;
    }
    public int getAngulodeGiro() {
        return angulodeGiro;
    }
    public double getPeso() {
        return peso;
    }
    public int getRuedas() {
        return ruedas;
    }
    public int getVelocidad() {
        return velocidad;
    }

    public static class Auto extends Vehiculo {
        public Auto(int velocidad, int aceleracion, int angulodeGiro, String patente, String marca, String modelo) {
            super(velocidad, aceleracion, angulodeGiro, patente, 1000, 4);
        }
    }

    public static class Moto extends Vehiculo {
        public Moto(int velocidad, int aceleracion, int angulodeGiro, String patente, String marca, String modelo) {
            super(velocidad, aceleracion, angulodeGiro, patente, 300, 2);
        }
    }
}
