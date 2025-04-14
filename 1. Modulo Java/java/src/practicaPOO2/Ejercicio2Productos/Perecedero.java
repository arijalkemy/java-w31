package practicaPOO2.Ejercicio2Productos;

public class Perecedero extends Producto implements IProducto {
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
        double precioFinal = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            return precioFinal - (precioFinal * 0.75); // 25% del precio
        } else if (diasPorCaducar == 2) {
            return precioFinal - (precioFinal * 0.67); // 33% del precio
        } else if (diasPorCaducar >= 3) {
            return precioFinal - (precioFinal / 2); // 50% del precio
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                "} " + super.toString();
    }
}
