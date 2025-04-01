package bancoAbstracto;

public class Deposito implements Transaccion {

    @Override
    public boolean transaccionOk() {
        System.out.println("Despositando dinero correctamente.");
        return true;
    }

    @Override
    public boolean transaccionNoOK() {
        System.out.println("Fallo el deposito de dinero.");
        return false;
    }
}

