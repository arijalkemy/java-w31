package com.mercadolibre;

public class Producto {
    protected String nombre;
    protected Double precio;

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public void calcular(Integer cantidadDeProductos){
        Double calculo = this.precio * cantidadDeProductos;
        System.out.println("El calculo de " + this.getNombre() + " dio: " + calculo);
    }

    @Override
    public String toString() {
        return "Producto: " +
                "nombre: '" + nombre + '\'' +
                ", precio: " + precio;
    }
}
