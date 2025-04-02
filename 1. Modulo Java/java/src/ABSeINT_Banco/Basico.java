package ABSeINT_Banco;
public class Basico extends Cliente {
    @Override
    public void realizarTransaccion(Ejecutivo.Transaccion transaccion) {
        if(transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetiroEfectivo) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}