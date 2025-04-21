package agenciaDeTurismo;

public class Reserva {
    private String tipo;
    private Double precio;

    public Reserva(String tipo, Double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

}
