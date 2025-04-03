package main.java;

public class Deposito implements Transaccion{
    @Override
    public boolean transaccionOk() {
        System.out.println("se realizo deposito");
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        System.out.println("no se realizo deposito");
        return false;
    }
}
