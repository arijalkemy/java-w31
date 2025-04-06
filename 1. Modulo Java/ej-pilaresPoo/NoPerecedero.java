public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "NoPerecedero{" +
                "nombre='" + nombre + '\'' +
                "precio='" + precio + '\'' +
                "tipo='" + tipo + '\'' +
                '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}