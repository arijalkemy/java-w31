package ejercicio_2;

public class Perecedero extends Producto{
     private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }
    @Override
    public Double calcular(int cantidadDeProductos){
        switch (diasPorCaducar){
            case 1: return (this.getPrecio() * cantidadDeProductos) - (this.getPrecio()*0.25);
            case 2: return (this.getPrecio() * cantidadDeProductos) - (this.getPrecio()*0.33);
            case 3: return (this.getPrecio() * cantidadDeProductos) - (this.getPrecio()*0.50);
            default: return this.getPrecio() * cantidadDeProductos;
        }
    }
}
