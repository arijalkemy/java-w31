package org.example.P2OOP;

public class Perecedero extends Producto{
    int diasPorCaducar;

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
    public double calcularPrecio(int cantidadDeProductos) {
        double total = cantidadDeProductos * precio;
        if (diasPorCaducar <= 1) {
            return total/4;
        } else if (diasPorCaducar == 2) {
            return total/3;
        } else if (diasPorCaducar == 3) {
            return total/2;
        }

        return total;
    }
}
