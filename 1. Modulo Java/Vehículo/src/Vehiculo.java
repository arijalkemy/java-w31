public class Vehiculo {
    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(String modelo, String marca, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Precio: " + costo;
    }
}
