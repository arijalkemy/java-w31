package ejercicio_tansacciones;

public class Colaborador extends Cliente {
    @Override
    public void realizarDeposito() {
        deposito.transaccionNoOk();
    }

    @Override
    public void realizarTransferencia() {
        transferencia.transaccionNoOk();
    }

    @Override
    public void consultarSaldo() {
        consulta.transaccionOk();
    }

    @Override
    public void pagarServicios() {
        pago.transaccionNoOk();
    }

    @Override
    public void retirarEfectivo() {
        retiro.transaccionOk();
    }
}
