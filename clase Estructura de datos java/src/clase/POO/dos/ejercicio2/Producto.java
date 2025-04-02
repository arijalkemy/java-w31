package clase.POO.dos.ejercicio2;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Double calcular(int cantidadDeProductos){
      return (double) (cantidadDeProductos * (int)precio);
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString(){
        return "Nombre: " + nombre + "\nPrecio: " + precio;
    }

}
