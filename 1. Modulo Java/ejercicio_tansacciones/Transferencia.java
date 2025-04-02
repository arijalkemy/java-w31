package E1;

public class Transferencia implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no realizada");
    }

    public Transferencia() {
    }
}
