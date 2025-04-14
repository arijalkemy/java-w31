package clasesAbstractasEInterfaces.ejercicio1;

public class ConsultarSaldo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consultar saldo OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consultar saldo NO OK");
    }
}
