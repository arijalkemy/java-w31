package main.java;

public class Ejecutivo {
    public void realizarDeposito(){
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }
    public void realizarTransaccio(){
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOk();
    }
}
