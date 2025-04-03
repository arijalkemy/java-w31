package ejercicio_2;

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
    public double calcular(int cantidadDeProductos) {
        double precioBase = super.calcular(cantidadDeProductos);
        if(diasPorCaducar == 1){
            precioBase = precioBase/4;
        } else if (diasPorCaducar == 2) {
            precioBase = precioBase/3;
        }else if(diasPorCaducar == 3){
            precioBase = precioBase/2;
        }
        return precioBase;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
