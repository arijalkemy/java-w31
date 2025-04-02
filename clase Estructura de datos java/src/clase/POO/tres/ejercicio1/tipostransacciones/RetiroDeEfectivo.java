package clase.POO.tres.ejercicio1.tipostransacciones;

public class RetiroDeEfectivo implements Transaccion {
    public void realizarTransaccion() {
        System.out.println("Retiro de efectivo realizado");
        transaccionOk();
    }
}
