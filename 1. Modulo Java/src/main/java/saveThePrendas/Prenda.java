package saveThePrendas;

public class Prenda {
    private String prenda;
    private String modelo;

    public Prenda(String prenda, String modelo) {
        this.prenda = prenda;
        this.modelo = modelo;
    }

    public String getPrenda() {
        return prenda;
    }

    public void setPrenda(String prenda) {
        this.prenda = prenda;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "prenda='" + prenda + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
