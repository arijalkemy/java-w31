package autos;

public class Vehiculo {
    private final String marca;
    private final String modelo;
    private final int costo;

    public Vehiculo(String marca, String modelo, int costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCosto() {
        return costo;
    }
}
