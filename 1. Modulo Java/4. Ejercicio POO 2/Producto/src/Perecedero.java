public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    //get de dias por caducar
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    //set de dias por caducar
    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDias Por Caducar: " + this.diasPorCaducar;
    }

    @Override
    public int getCalculo(int cantidadDeProductos) {
        int precioBase = super.getCalculo(cantidadDeProductos);

        /*switch (diasPorCaducar) {
            case 1:
                return precioBase/4;
            case 2:
                return precioBase/3;
            case 3:
                return precioBase/2;
            default:
                return precioBase;
        }*/
        return switch (diasPorCaducar) {
            case 1 -> precioBase / 4;
            case 2 -> precioBase / 3;
            case 3 -> precioBase / 2;
            default -> precioBase;
        };
    }
}
