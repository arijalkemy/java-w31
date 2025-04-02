package POO_Distribuidora;

public class Producto {
    private String nombre;
    private double precio;

    //constructor
    public Producto(String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    //getter y setter
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //toString
    public String toString(){
        return "Producto [nombre: " + nombre + ", precio: "+precio+"]";
    }

    public double calcular(int cantidadDeProductos){
        return precio * cantidadDeProductos;
    }
}
