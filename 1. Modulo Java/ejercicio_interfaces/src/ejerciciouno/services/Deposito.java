package ejerciciouno.services;

import ejerciciouno.interfaces.IDeposito;

public class Deposito implements IDeposito {
    @Override
    public void realizarDeposito() {
        System.out.println("Realizando Deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Deposito Transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito Transaccion No Ok");
    }
}
