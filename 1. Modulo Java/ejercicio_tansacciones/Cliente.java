package E1;

public abstract class Cliente {
    protected Consulta consulta = new Consulta();
    protected Deposito deposito = new Deposito();
    protected Pago pago = new Pago();
    protected Retiro retiro = new Retiro();
    protected Transferencia transferencia = new Transferencia();

    public Cliente() {
    }

    public abstract void realizarDeposito();

    public abstract void realizarTransferencia();

    public abstract void consultarSaldo();

    public abstract void pagarServicios();

    public abstract void retirarEfectivo();

}
