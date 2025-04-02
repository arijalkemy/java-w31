package ABSeINT_Banco;
public class PagoServicios implements Ejecutivo.Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el pago de servicios.");
    }
}