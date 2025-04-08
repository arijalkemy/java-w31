package org.meli;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
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
        return super.toString() + "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public Double calcular(int cantidadDeProductos) {
        double precioFinal = getPrecio() * cantidadDeProductos;

        if (diasPorCaducar == 1) {
            precioFinal /= 4;
        } else if (diasPorCaducar == 2) {
            precioFinal /= 3;
        } else if (diasPorCaducar == 3) {
            precioFinal /= 2;
        }

        return precioFinal;
    }
}
