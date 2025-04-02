package dev.michell.herencia;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
        calcular(diasPorCaducar);
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double total =  super.calcular(cantidadDeProductos);

        if (getDiasPorCaducar() == 1) {
            total /= 4;
        }else if (getDiasPorCaducar() == 2) {
            total /= 3;
        }else if (getDiasPorCaducar() == 3) {
            total /= 2;
        }

        return total;
    }

    @Override
    public String toString() {
        return "nombre " + getNombre() + " precio " + getPrecio() + " dias " + getDiasPorCaducar();
    }
}
