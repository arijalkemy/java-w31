package co.com.mercadolibre;

public class Vehiculo {

    private double velocidad, aceleracion, peso, anguloDeGiro;
    private String patente;
    private int ruedas;

    public Vehiculo() {
    }

    public Vehiculo(double velocidad, double aceleracion, double peso, double anguloDeGiro,
                    String patente, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.peso = peso;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.ruedas = ruedas;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", peso=" + peso +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", ruedas=" + ruedas +
                '}';
    }
}
