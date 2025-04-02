package E2;

public class Perecedero extends Producto {
    private Integer diasPorCaducar;

    public Integer getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(Integer diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + ", dias por caducar=" + diasPorCaducar + "]";
    }

    @Override
    public Double calcular(Integer cantidadDeProductos) {
        Double total = super.calcular(cantidadDeProductos);
        switch (diasPorCaducar) {
            case 1:
                return total / 4;
            case 2:
                return total / 3;
            case 3:
                return total / 2;
            default:
                return total;
        }
    }
}
