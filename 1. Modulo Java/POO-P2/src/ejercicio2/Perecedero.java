package ejercicio2;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadProductos) {
         double costo = super.calcular(cantidadProductos);
        costo = (diasPorCaducar == 1) ? costo / 4 :
                (diasPorCaducar == 2) ? costo / 3 :
                        (diasPorCaducar == 3) ? costo / 2 : costo;

        return costo;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
