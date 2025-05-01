public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en la consulta de saldo.");
    }
}
