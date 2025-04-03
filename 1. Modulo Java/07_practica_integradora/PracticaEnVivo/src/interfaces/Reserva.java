package interfaces;

public abstract class Reserva {
    Double precio;
    Integer id;

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Reserva(Double precio, Integer id) {
        this.precio = precio;
        this.id = id;
    }

}
