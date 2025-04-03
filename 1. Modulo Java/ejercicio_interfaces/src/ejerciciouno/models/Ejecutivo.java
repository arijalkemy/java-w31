package ejerciciouno.models;

import ejerciciouno.interfaces.IDeposito;
import ejerciciouno.interfaces.ITransferencia;

public class Ejecutivo {
    private final IDeposito deposito;
    private final ITransferencia transferencia;

    public Ejecutivo(IDeposito deposito, ITransferencia transferencia) {
        System.out.println("\tEjecutivo");
        this.deposito = deposito;
        this.transferencia = transferencia;
    }

    public void realizarDeposito() {
        this.deposito.realizarDeposito();
    }

    public void estadoDeposito() {
        this.deposito.transaccionNoOk();
    }

    public void realizarTransferencia() {
        this.transferencia.realizarTransferencia();
    }

    public void estadoTransferencia() {
        this.transferencia.transaccionOk();
    }
}
