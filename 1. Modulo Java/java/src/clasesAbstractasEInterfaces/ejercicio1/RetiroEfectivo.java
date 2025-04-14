package clasesAbstractasEInterfaces.ejercicio1;

public class RetiroEfectivo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo NO OK");
    }
}
