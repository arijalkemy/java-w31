package bancoAbstracto;

public class PagoDeServicios implements Transaccion{
    @Override
    public boolean transaccionOk() {
        System.out.println("Servicio pagado correctamente.");
        return true;
    }

    @Override
    public boolean transaccionNoOK() {
        System.out.println("Error al pagar el servicio.");
        return false;
    }
}
