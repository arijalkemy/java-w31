package co.com.mercadolibre.ejerciciodos.domain;

public class Perishable extends Product {

    private int diasPorCaducar;

    public Perishable(String name, double precio, int diasPorCaducar) {
        super(name, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        double priceToBeReduce = super.calcular(cantidadDeProductos);
        double result = 0;

        switch (this.diasPorCaducar) {
            case 1:
                result = priceToBeReduce/4; 
                break;
            case 2:
                result = priceToBeReduce/3;
                break;      
            default:
                result = priceToBeReduce/2;
        }

        return result;
    }

    @Override
    public String toString() {
        return "Perishable [diasPorCaducar=" + diasPorCaducar + ", getName()=" + getName() + ", getDiasPorCaducar()="
                + getDiasPorCaducar() + ", getPrecio()=" + getPrecio() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }

    

    

    
}
