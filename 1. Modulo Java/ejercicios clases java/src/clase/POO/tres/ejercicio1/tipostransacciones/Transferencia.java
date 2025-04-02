package clase.POO.tres.ejercicio1.tipostransacciones;

public class Transferencia implements Transaccion {
    public void realizarTransaccion() {
        System.out.println("Transferencia realizada");
        transaccionOk();
    }
}
