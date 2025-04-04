public class Reserva {
    private Double costo;
    private String tipo;

    public Reserva(Double costo, String tipo) {
        this.costo = costo;
        this.tipo = tipo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "costo=" + costo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
