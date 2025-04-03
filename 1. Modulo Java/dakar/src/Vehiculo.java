public abstract class Vehiculo {
    protected Integer velocidad;
    protected Integer aceleracion;
    protected Double anguloDeGiro;
    protected String patente;
    protected Integer peso;
    protected Integer ruedas;
    protected Double valorParaGanar;

    public Vehiculo(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }


    public Integer getVelocidad() {
        return velocidad;
    }

    public Integer getAceleracion() {
        return aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public Integer getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public Double getValorParaGanar() {
        return valorParaGanar;
    }

    private void calcularValorParaGanar() {
        valorParaGanar = velocidad * (aceleracion / 2) / (anguloDeGiro * (peso - ruedas * 100));
    }
}
