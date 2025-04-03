package Model.Prendas;

public abstract class Prenda {
    private String marca;
    private String modelo;
    private TipoPrenda tipoPrenda;

    public Prenda(String marca, String modelo, TipoPrenda tipoPrenda) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoPrenda = tipoPrenda;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "\nPrenda:" + "marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipoPrenda;
    }
}
