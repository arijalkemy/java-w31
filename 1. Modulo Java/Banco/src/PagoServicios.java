public class PagoServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en el pago de servicios.");
    }
}
