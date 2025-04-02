package ABSeINT_Banco;
public class RetiroEfectivo implements Ejecutivo.Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el retiro de efectivo.");
    }
}