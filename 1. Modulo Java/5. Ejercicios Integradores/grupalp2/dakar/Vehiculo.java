package dakar;

public class Vehiculo {

    private int velocidad;
    private int aceleracion;
    private int anguloDeGiro;
    private String patente;
    private int pesoEnKg;
    private int cantidadDeRuedas;

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente, int pesoEnKg, int cantidadDeRuedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.pesoEnKg = pesoEnKg;
        this.cantidadDeRuedas = cantidadDeRuedas;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(int aceleracion) {
        this.aceleracion = aceleracion;
    }

    public int getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(int anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getPesoEnKg() {
        return pesoEnKg;
    }

    public void setPesoEnKg(int pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }

    public int getCantidadDeRuedas() {
        return cantidadDeRuedas;
    }

    public void setCantidadDeRuedas(int cantidadDeRuedas) {
        this.cantidadDeRuedas = cantidadDeRuedas;
    }
}
