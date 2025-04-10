package clases;

public abstract class Vehiculo {
    private Integer velocidad;
    private Integer aceleracion;
    private Integer anguloGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;

    public Vehiculo(Integer velocidad, Integer aceleracion, Integer anguloGiro, String patente, Double peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public Integer getAceleracion() {
        return aceleracion;
    }

    public Integer getAnguloGiro() {
        return anguloGiro;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

}
