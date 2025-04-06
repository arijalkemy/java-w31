public class Perecedero extends Producto {
   private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Perecedero{" +
                "nombre=" + nombre +
                "precio=" + precio +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioReducido = precio;
        switch (diasPorCaducar) {
            case 3:
                precioReducido = precio / 2;
                break;
            case 2:
                precioReducido = precio / 3;
                break;
            case 1:
                precioReducido = precio / 4;
                break;
        }
        return precioReducido * cantidadDeProductos;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}