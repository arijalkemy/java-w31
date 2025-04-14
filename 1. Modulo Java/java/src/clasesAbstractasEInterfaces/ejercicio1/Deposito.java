package clasesAbstractasEInterfaces.ejercicio1;

public class Deposito implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Deposito OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito NO OK");
    }
}
