package exerciseIntegrator2.exercise2.clases;

public class  Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double AnguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;
    public Vehiculo(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso,
            Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        AnguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
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
    public Double getAnguloDeGiro() {
        return AnguloDeGiro;
    }
    public void setAnguloDeGiro(Double anguloDeGiro) {
        AnguloDeGiro = anguloDeGiro;
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
    @Override
    public String toString() {
        return "Vehiculo [velocidad=" + velocidad + ", aceleracion=" + aceleracion + ", AnguloDeGiro=" + AnguloDeGiro
                + ", patente=" + patente + ", peso=" + peso + ", ruedas=" + ruedas + "]";
    }

    
    

}
