package Practica4;

public class NoPerecedero extends Producto{
    private String tipo;

    public NoPerecedero(double precio, java.lang.String nombre, java.lang.String tipo) {
        super(precio, nombre);
        this.tipo = tipo;
    }

    public java.lang.String getTipo() {
        return tipo;
    }

    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }

    @Override
    public java.lang.String toString() {
        return super.toString() + "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
