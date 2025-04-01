package bancoAbstracto;

public class Transferencia implements Transaccion {

    @Override
    public boolean transaccionOk() {
        System.out.println("Transfiriendo dinero correctamente.");
        return true;
    }

    @Override
    public boolean transaccionNoOK() {
        System.out.println("Fallo la transferencia de dinero.");
        return true;
    }
}

