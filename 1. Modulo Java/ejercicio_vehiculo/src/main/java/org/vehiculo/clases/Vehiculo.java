package org.vehiculo.clases;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int precio;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Vehiculo(String modelo, int precio, String marca) {
        this.modelo = modelo;
        this.precio = precio;
        this.marca = marca;
    }
}
