package com.mercadolibre.bootcamp.model;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String name, Double precio, Integer diasPorCaducar){
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
    public Double calcular(int cantidadDeProductos){
        Double valor = super.getPrecio() * cantidadDeProductos;
        switch (diasPorCaducar) {
            case 1:
                valor /= 4;
                break;
            case 2:
                valor /= 3;
                break;
            case 3:
                valor /= 2;
                break;
        }
        return valor;
    }

    @Override
    public String toString(){
        return "Perecedero{" +
                "nombre='" + super.getNombre() + '\'' +
                ", precio='" + super.getPrecio() + '\'' +
                ", dias por caducar='" + diasPorCaducar;
    } 
}
