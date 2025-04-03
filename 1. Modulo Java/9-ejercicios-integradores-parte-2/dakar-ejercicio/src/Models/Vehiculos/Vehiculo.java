package Models.Vehiculos;

public abstract class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;
    private TipoVehiculo precio;

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, TipoVehiculo tipoVehiculo) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;

        if (tipoVehiculo == TipoVehiculo.AUTO) {
            this.peso = 1000D;
            this.ruedas = 4;
        } else if (tipoVehiculo == TipoVehiculo.MOTO) {
            this.peso = 300D;
            this.ruedas = 2;
        }
    }

    public String getPatente() {
        return patente;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public TipoVehiculo getPrecio() {
        return precio;
    }
}
