package clase.POO.tres.ejercicio1.tipostransacciones;

public class ConsultaDeSaldo implements Transaccion {
    public void realizarTransaccion() {
        System.out.println("Consultando saldo");
        transaccionOk();
    }
}
