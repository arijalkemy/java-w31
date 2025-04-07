class PagoServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El pago de servicios no ha podido ser realizado.");
    }
}