public class Vehiculo {

    public String modelo;
    public String marca;
    public int costo;

    public Vehiculo(String modelo, String marca, int costo) { this.modelo = modelo; this.marca = marca; this.costo = costo; }

    public String getModelo() {
        return this.modelo;
    }
    public String getMarca() {
        return this.marca;
    }
    public int getCosto() {
        return this.costo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
}