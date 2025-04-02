package clase.POO.tres.ejercicio1.tipostransacciones;

public interface Transaccion {

    default void transaccionOk() {
        System.out.println("Transacción realizada con éxito.");
    }
    default void transaccionNoOk() {
        System.out.println("Error en la transacción.");
    }

    public void realizarTransaccion();
}
