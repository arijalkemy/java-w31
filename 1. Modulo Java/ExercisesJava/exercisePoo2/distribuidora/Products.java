package exercisePoo2.distribuidora;

public class Products {
    private String nombre;
    private double precio;

    public Products(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    } 
    //metodos
    public String toString() {
        return "Products [nombre=" + nombre + ", precio=" + precio + "]";
    }

    public  double calculo(int cantidadProductos){
        return precio*cantidadProductos;
    }
    
}
