package practicaPOO2.Ejercicio2Productos;

public class Producto implements IProducto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
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
        return "Producto - " +
                " nombre = '" + nombre + '\'' +
                ", precio = " + precio;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return precio*cantidadDeProductos;
    }
}
