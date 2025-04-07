package dev.michellarias.dakar;

public abstract class Vehiculo {

    private Double velocidad;
    private Double aceleracion;
    private Double anguloGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;
    private Double stats;


    public Vehiculo(Double velocidad, Double aceleracion, Double anguloGiro, String patente, Double peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
        this.stats = calcularStats();
    }

    public Double calcularStats() {
        Double aceleracionAux = getAceleracion() * 0.5;
        Double giroPorPeso = (getAnguloGiro() * (getPeso() - getRuedas() * 100));
        Double statsOut = getVelocidad() * aceleracionAux /  giroPorPeso;

        return statsOut;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Double getAnguloGiro() {
        return anguloGiro;
    }

    public void setAnguloGiro(Double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }

    public Double getStats() {
        return stats;
    }

    public void setStats(Double stats) {
        this.stats = stats;
    }
}
