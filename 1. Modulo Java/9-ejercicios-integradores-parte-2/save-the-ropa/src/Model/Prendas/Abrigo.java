package Model.Prendas;

public class Abrigo extends Prenda {
    private Boolean tieneCapucha;

    public Abrigo(String marca, String modelo, Boolean tieneCapucha, TipoPrenda tipoPrenda) {
        super(marca, modelo, tipoPrenda);
        this.tieneCapucha = tieneCapucha;
    }

    @Override
    public String toString() {
        return super.toString() + " TieneCapucha: " + tieneCapucha + "\n";
    }
}
