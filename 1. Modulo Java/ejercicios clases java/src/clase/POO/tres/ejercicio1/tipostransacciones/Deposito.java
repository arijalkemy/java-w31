package clase.POO.tres.ejercicio1.tipostransacciones;

public class Deposito implements Transaccion{
    public void realizarTransaccion() {
        System.out.println("Deposito realizado");
        transaccionOk();
    }
}
