package ABSeINT_Banco;
public class ConsultaSaldo implements Ejecutivo.Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al consultar el saldo.");
    }
}