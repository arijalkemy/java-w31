package practica;
public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar(){
        return diasPorCaducar;
    }
    public void setDiasPorCaducar(int diasPorCaducar){
        this.diasPorCaducar = diasPorCaducar;
    }
    public Perecedero(int diasPorCaducar, String nombre, double precio) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }
    public String toString() {
        return super.toString() +
                "diasPorCaducar=" + diasPorCaducar;
    }   

    @Override
    public int calcular(int cantidadDeProductos){
        Double precio = this.getPrecio();
        System.out.println("El precio sin reduccion es: " + precio);
        switch (diasPorCaducar) {
            case 1:
                precio /= 4;
                break;
            case 2:
                precio /= 3;
                break;
            case 3:
                precio /= 2;
                break;
            default:
                break;
        }

        return precio.intValue() * cantidadDeProductos;
    }
}
