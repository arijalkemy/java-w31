package main.java;

public class ConsultaSaldo implements Transaccion{
    @Override
    public boolean transaccionOk() {
        System.out.println("Se consulto saldo");
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        System.out.println("No se pudo consultar saldo");
        return false;
    }
}
