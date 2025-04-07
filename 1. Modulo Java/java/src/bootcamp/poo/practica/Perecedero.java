package bootcamp.poo.practica;

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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProdcuctos) {
        switch (getDiasPorCaducar()) {
            case 1:
                setPrecio(getPrecio() / 4);
                break;
            case 2:
                setPrecio(getPrecio() / 3);
                break;
            case 3:
                setPrecio(getPrecio() / 2);
                break;
            default:
                break;
        }
       return super.calcular(cantidadDeProdcuctos);
    }
}
