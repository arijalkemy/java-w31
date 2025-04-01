package bancoAbstracto;

public abstract class Cliente {
    public boolean realizarTransaccion(Transaccion transaccion) {
        // Random para anular una transaccion cada tanto!
        int random = (int) (Math.random() * 100);
        if (random < 35) {
            transaccion.transaccionNoOK();
            return false;
        } else {
            transaccion.transaccionOk();
            return true;
        }

    }
}
