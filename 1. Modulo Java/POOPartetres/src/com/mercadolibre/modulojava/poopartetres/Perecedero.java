package com.mercadolibre.modulojava.poopartetres;

public class Perecedero extends Producto{
    private int diasPorCaducar;
    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar=diasPorCaducar;
    }
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }
    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
    @Override
    public String toString() {
        return super.toString() + "DiasPorCaducar=" + diasPorCaducar;
    }
    @Override
    public Double calcular(int cantidadDeProductos) {

        if(diasPorCaducar==1){
            return super.calcular(cantidadDeProductos)/4;
        }else if(diasPorCaducar==2){
            return super.calcular(cantidadDeProductos)/3;
        }else if(diasPorCaducar==3){
            return super.calcular(cantidadDeProductos)/2;
        }else{
            return super.calcular(cantidadDeProductos);
        }
    }
}
