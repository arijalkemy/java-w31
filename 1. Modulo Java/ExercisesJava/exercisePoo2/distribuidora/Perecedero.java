package exercisePoo2.distribuidora;

public class Perecedero extends Products {

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
        return "Perecedero [diasPorCaducar=" + diasPorCaducar + "]";
    }

    @Override
    public double calculo(int cantidadProductos) {

        if (this.diasPorCaducar == 1) {
            return super.calculo(cantidadProductos) / 4;
        }
        if (this.diasPorCaducar == 2) {
            return super.calculo(cantidadProductos) / 3;
        }
        if (this.diasPorCaducar == 3) {
            return super.calculo(cantidadProductos) / 2;
        }
        return super.calculo(cantidadProductos);
    }

}
