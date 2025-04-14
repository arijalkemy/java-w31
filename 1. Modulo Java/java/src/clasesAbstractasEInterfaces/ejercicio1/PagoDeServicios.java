package clasesAbstractasEInterfaces.ejercicio1;

public class PagoDeServicios implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio NO OK");
    }
}
