package Model.Prendas;

public class Remera extends Prenda {
    private Double largo;
    private Double ancho;

    public Remera(String marca, String modelo, Double largo, Double ancho, TipoPrenda tipoPrenda) {
        super(marca, modelo, tipoPrenda);
        this.largo = largo;
        this.ancho = ancho;
    }

    @Override
    public String toString() {
        return super.toString() + " Largo: " + largo + " Ancho: " + ancho;
    }

}
