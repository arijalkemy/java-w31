package clasesAbstractasEInterfaces.ejercicio1;

public class Basico extends Cliente {

    @Override
    public void realizarTransferencia(ITransaccion transaccion) {
        if (transaccion instanceof ConsultarSaldo || transaccion instanceof PagoDeServicios || transaccion instanceof RetiroEfectivo){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
