package practica;
public class Producto {
    private String nombre;
    private Double precio;

    public Double getPrecio(){
        return precio;
    }
    public String geNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPrecio(Double precio){
        this.precio = precio;
    }
    public Producto(String nombre, Double precio){ this.nombre = nombre; this.precio = precio;};
    public String toString(){
        return "Nombre del producto: " + this.nombre + " precio del producto: " + this.precio;
    }
    public int calcular(int cantidadDeProductos){
        return this.precio.intValue() * cantidadDeProductos;
    }
}
