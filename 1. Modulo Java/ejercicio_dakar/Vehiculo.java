package ejercicio_dakar;

public class Vehiculo {
    protected Double velocidad;
    protected Double aceleracion;
    protected Double anguloDeGiro;
    protected String patente;
    protected Double peso;
    protected Integer ruedas;

    public Vehiculo(Double velicidad, Double aceleracion, Double anguloDeGiro, String patente) {
        this.velocidad = velicidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public Double getVelicidad() {
        return velocidad;
    }

    public void setVelicidad(Double velicidad) {
        this.velocidad = velicidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
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

    public Double calcularFormula() {
        return velocidad * 0.5 * aceleracion / anguloDeGiro * (peso - ruedas * 100);
    }

    @Override
    public String toString() {
        return "Vehiculo [patente=" + patente + "]";
    }
}
