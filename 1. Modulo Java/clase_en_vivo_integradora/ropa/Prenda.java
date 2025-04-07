package ropa;

public class Prenda {
    private String marca;
    private String modelo;
    private int id;

    public Prenda(String marca, String modelo, int id) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    
    
}