public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    // getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // setters
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //toString

    public String toString() {
        return "Nombre: " + nombre + "\nPrecio: $" + precio;
    }

    //calcular

    public int getCalculo(int cantidadDeProductos) {
        return (int) (this.precio * cantidadDeProductos);
    }
}

