public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Dias por caducar: " + diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);

        if (diasPorCaducar == 1) {
            return precioFinal * 0.25;
        } else if (diasPorCaducar == 2) {
            return precioFinal * 0.33;
        } else if (diasPorCaducar == 3) {
            return precioFinal * 0.5;
        }

        return precioFinal;
    }

    // Getters y Setters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
