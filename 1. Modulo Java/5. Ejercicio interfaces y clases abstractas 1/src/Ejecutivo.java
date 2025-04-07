class Ejecutivo {
    public void realizarDeposito() {
        Transaccion deposito = new Deposito();
        deposito.transaccionOk();
    }

    public void realizarTransferencia() {
        Transaccion transferencia = new Transferencia();
        transferencia.transaccionOk();
    }
}