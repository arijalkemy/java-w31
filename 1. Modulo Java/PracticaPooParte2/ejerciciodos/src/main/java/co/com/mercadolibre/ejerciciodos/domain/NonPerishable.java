package co.com.mercadolibre.ejerciciodos.domain;

public class NonPerishable extends Product {

    private String tipo;

    public NonPerishable(String name, double precio, String tipo) {
        super(name, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }

    

}
