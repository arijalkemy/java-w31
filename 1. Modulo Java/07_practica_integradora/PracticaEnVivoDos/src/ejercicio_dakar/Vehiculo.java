package ejercicio_dakar;

public class Vehiculo {
    Integer velocidad;
    Integer aceleracion;
    Integer anguloDeGiro;
    Double peso;
    Integer ruedas;
    String patente;

    public Vehiculo(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, Double peso, Integer ruedas, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.ruedas = ruedas;
        this.patente = patente;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public Integer getAceleracion() {
        return aceleracion;
    }

    public Integer getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public String getPatente() {
        return patente;
    }
}
