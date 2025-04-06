public class Ejecutivo extends TransaccionManager implements Deposito, Transferencia {
    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito...");
        transaccionOk();
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia...");
        transaccionOk();
    }
}
