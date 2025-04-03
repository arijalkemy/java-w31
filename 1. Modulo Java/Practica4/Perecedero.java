package Practica4;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(double precio, String nombre, int diasPorCaducar) {
        super(precio, nombre);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public java.lang.String toString() {
        return super.toString() + "Perecedero{" +
                "diasPorCaducar='" + diasPorCaducar + '\'' +
                '}';
    }

    @Override
    public void calcular( int cantidadDeProductos){
        int reduccion = 1;
        if(this.diasPorCaducar == 1){
            reduccion = 4;
        }
        if(this.diasPorCaducar == 2){
            reduccion = 3;
        }
        if(this.diasPorCaducar == 3){
            reduccion = 2;
        }
        super.calcular(cantidadDeProductos);
        this.setPrecio(this.getPrecio() - this.getPrecio()*reduccion);
    }
}