package clases;

public class Client {
    String nombre;
    Integer dni;

    public Boolean getTieneDescuento() {
        return tieneDescuento;
    }

    public void setTieneDescuento(Boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }

    Boolean tieneDescuento;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Client(String nombre, Integer dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.tieneDescuento = Boolean.FALSE;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }
}
