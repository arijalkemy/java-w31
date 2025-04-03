package dakar;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private int peso;
    private int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public int getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }
}
