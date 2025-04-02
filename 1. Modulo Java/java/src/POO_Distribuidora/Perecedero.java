package POO_Distribuidora;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    //constructor
    public Perecedero(String nombre, double precio, int diasPorCaducar){
        super(nombre, precio); //llamada al constructor de clase padre
        this.diasPorCaducar=diasPorCaducar;
    }

    //get y set
    public int getDiasPorCalcular() {
        return diasPorCaducar;
    }

    public void setDiasPorCalcular(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString(){
        return super.toString() + ", Perecedero [diasPorCaducar: " + diasPorCaducar + "]";
    }

    //sobreescribir metodo calcular
    @Override
    public double calcular(int cantidadDeProductos){
        double precioFinal = super.calcular(cantidadDeProductos); //llama al metodo de la clase padre

        //ajustar precio segun dias por caducar
        if (diasPorCaducar == 1){
            precioFinal/=4; //reduce a un cuarto del precio base
        } else if (diasPorCaducar == 2){
            precioFinal /=3;
        } else if (diasPorCaducar == 3){
            precioFinal /=2;
        }
        return precioFinal;
    }
}
