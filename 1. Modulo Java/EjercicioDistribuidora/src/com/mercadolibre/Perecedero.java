package com.mercadolibre;

public class Perecedero extends Producto{
    private Integer diasPorCaducar;

    public Perecedero(String nombre, Double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Integer getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(Integer diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero: " +
                "diasPorCaducar: " + diasPorCaducar +
                ", nombre: '" + nombre + '\'' +
                ", precio: " + precio;
    }
    @Override
    public void calcular(Integer cantidadDeProductos){
        Double calculo = this.precio * cantidadDeProductos;
        switch (this.diasPorCaducar) {
            case 1:
                calculo /= 4;
                break;
            case 2:
                calculo /= 3;
                break;
            case 3:
                calculo /= 2;
                break;
        }
        System.out.println("El calculo de " + this.getNombre() + " dio: " + calculo);
    }
}
