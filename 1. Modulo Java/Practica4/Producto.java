package Practica4;

public class Producto {

    private double precio;
    private String nombre;

    public Producto(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public void calcular( int cantidadDeProductos){
        this.precio = this.precio * cantidadDeProductos;
    }


}
