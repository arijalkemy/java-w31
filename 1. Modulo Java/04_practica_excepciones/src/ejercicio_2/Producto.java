package ejercicio_2;

public class Producto {
    private String nombre;
    private Double precio;

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "Nombre:" + this.getNombre() + ". Precio: " + this.calcular(1);
    }

    public Double calcular(int cantidadProductos){
        return precio * cantidadProductos;
    }

}
