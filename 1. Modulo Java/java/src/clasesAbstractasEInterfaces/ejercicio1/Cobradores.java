package clasesAbstractasEInterfaces.ejercicio1;

public class Cobradores extends Cliente{
    @Override
    public void realizarTransferencia(ITransaccion transaccion) {
        if (transaccion instanceof RetiroEfectivo || transaccion instanceof ConsultarSaldo) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
