public class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void hacerReclamo(){

    }

    @Override
    public String toString() {
        return String.format("Marca: %s | Modelo: %s", marca, modelo);
    }
}
