package bancoAbstracto;

public class ConsultaSaldo implements Transaccion {

    @Override
    public boolean transaccionOk() {
        System.out.println("Consultando saldo, tu saldo es: ");
        return true;
    }

    @Override
    public boolean transaccionNoOK() {
        System.out.println("Error al consultar el saldo.");
        return false;
    }
}

