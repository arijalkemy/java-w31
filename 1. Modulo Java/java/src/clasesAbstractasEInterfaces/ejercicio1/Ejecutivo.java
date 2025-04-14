package clasesAbstractasEInterfaces.ejercicio1;

public class Ejecutivo extends Cliente{

    @Override
    public void realizarTransferencia(ITransaccion transaccion) {
        if (transaccion instanceof Deposito || transaccion instanceof Transferencia ) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
