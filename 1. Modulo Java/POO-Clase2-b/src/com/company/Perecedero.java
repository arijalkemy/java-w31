package com.company;

public class Perecedero extends Producto{
    private Integer diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, Double precio) {
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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
    @Override
    public int calcular(int cantidadDeProductos){
        if(this.diasPorCaducar.equals(1)){
            return ((int) (super.getPrecio()*cantidadDeProductos))/4;
        }else if(this.diasPorCaducar.equals(2)){
            return ((int) (super.getPrecio()*cantidadDeProductos))/3;
        }else if(this.diasPorCaducar.equals(3)) {
            return ((int) (super.getPrecio() * cantidadDeProductos)) / 2;
        }else{
            return (int) (super.getPrecio() * cantidadDeProductos);
        }
    }

}
