package ejercicio_tansacciones;

public class Ejecutivo extends Cliente {

    @Override
    public void realizarDeposito() {
        deposito.transaccionOk();
    }

    @Override
    public void realizarTransferencia() {
        transferencia.transaccionOk();
    }

    @Override
    public void consultarSaldo() {
        consulta.transaccionNoOk();
    }

    @Override
    public void pagarServicios() {
        pago.transaccionNoOk();
    }

    @Override
    public void retirarEfectivo() {
        retiro.transaccionNoOk();
    }

}
