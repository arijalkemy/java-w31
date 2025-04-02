package ABSeINT_Banco;
public class Deposito implements Ejecutivo.Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el depósito.");
    }
}