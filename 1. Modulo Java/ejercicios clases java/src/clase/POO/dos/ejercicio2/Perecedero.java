package clase.POO.dos.ejercicio2;

public class Perecedero extends Producto{
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
        return "Perecedero con " + diasPorCaducar + " dias de caducidad";
    }

    @Override
    public Double calcular(int cantidadDeProductos){
        double resultado = super.calcular(cantidadDeProductos);
        if ( diasPorCaducar == 1) {
            resultado = resultado / 4;
        } else if (diasPorCaducar == 2) {
            resultado = resultado / 3;
        } else if (diasPorCaducar == 3) {
            resultado = resultado / 2;
        }
        return resultado;
    }
}
