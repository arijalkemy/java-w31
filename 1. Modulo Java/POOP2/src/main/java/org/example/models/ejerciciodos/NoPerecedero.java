package org.example.models.ejerciciodos;

public class NoPerecedero extends Producto{
    private String tipo;

    public NoPerecedero(String nombre, Double precio, String tipo) {
        super(nombre,precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Double calcular(int cantidadDeProductos){
        Double total = super.getPrecio()*cantidadDeProductos;
        System.out.println("Total precio en alimentos no perecederos: "+total);
        return total;
    }

    public String toString(){
        return super.toString() + "Tipo: " + tipo;
    }
}
