package clasesagencia;

public class Cliente {
    private Integer dni;
    private String nombre;
    private String apellido;
    private Double descuento;

    public Cliente(Integer dni, String nombre, String apellido, Double descuento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descuento = descuento;
    }

    @Override
    public String toString(){
        return "Dni: " + dni + "\nNombre: " + nombre + "\nApellido: " + apellido;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
}
