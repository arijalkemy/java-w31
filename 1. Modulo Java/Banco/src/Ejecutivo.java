public class Ejecutivo {
    public void realizarDeposito() {
        new Deposito().transaccionOk();
    }

    public void realizarTransferencia() {
        new Transferencia().transaccionOk();
    }
}
