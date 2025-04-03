package P2.Ejercicio2;

/*
 * Crear la clase NoPerecedero, la misma va a tener un atributo
 * llamado tipo, el mismo va a ser un String, crear setters,
 * getters, constructor y método toString(); en esta clase el
 * método calcular() va a hacer exactamente lo mismo que en la
 * clase Producto.
 */
public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String tipo, String nombre, double precio) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
