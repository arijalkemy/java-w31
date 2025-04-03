package exercisePoo2.distribuidora;

public class NoPerecederos extends Products {

    private String tipo;

    public NoPerecederos(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecederos [tipo=" + tipo + "]";
    }

    @Override
    public double calculo(int cantidadProductos) {
        return super.calculo(cantidadProductos);
    }

}
