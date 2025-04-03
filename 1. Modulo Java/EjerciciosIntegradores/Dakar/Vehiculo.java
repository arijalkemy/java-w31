package EjerciciosIntegradores.Dakar;

public class Vehiculo {
    Long velocidad;
    Long aceleracion;
    Long anguloDeGiro;
    String patente;
    Integer peso;
    Integer cantRuedas;

    public Vehiculo(Long velocidad, Long aceleracion, Long anguloDeGiro, String patente, Integer peso, Integer cantRuedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.cantRuedas = cantRuedas;
    }
    public Integer getPeso() {
        return peso;
    }
    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    public Integer getCantRuedas() {
        return cantRuedas;
    }
    public void setCantRuedas(Integer cantRuedas) {
        this.cantRuedas = cantRuedas;
    }
    public Long getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(Long velocidad) {
        this.velocidad = velocidad;
    }
    public Long getAceleracion() {
        return aceleracion;
    }
    public void setAceleracion(Long aceleracion) {
        this.aceleracion = aceleracion;
    }
    public Long getAnguloDeGiro() {
        return anguloDeGiro;
    }
    public void setAnguloDeGiro(Long anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }
    public String getPatente() {
        return patente;
    }
}
