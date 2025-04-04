package org.example.models.ejerciciodos;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre,Double precio,int diasPorCaducar) {
        super(nombre,precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public Double calcular(int cantidadDeProductos) {
        Double total= super.calcular(cantidadDeProductos);
        switch(this.diasPorCaducar){
            case 1: total = total/4;
                break;
            case 2: total = total/3;
                break;
            case 3: total = total/2;
                break;
            default:
                break;
        }
        System.out.println("Total precio en alimentos perecederos: "+total);
        return total;
    }

    public String toString() {
        return super.toString()+" dias para caducar: "+diasPorCaducar;
    }
}
