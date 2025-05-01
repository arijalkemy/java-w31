public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en el retiro de efectivo.");
    }
}