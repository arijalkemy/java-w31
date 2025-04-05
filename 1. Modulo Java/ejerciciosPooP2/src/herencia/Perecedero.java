package herencia;



public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + " | Precio: " + this.getPrecio() + " | dias para caducar: " + this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
       double precioFinal = switch (diasPorCaducar){
            case 1 -> (this.getPrecio() * cantidadDeProductos)/4;
            case 2 -> (this.getPrecio() * cantidadDeProductos)/3;
            case 3 -> (this.getPrecio() * cantidadDeProductos)/2;
            default -> this.getPrecio() * cantidadDeProductos;
       };
       return precioFinal;
    }
}