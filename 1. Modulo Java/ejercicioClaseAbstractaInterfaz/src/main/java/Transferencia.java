package main.java;

public class Transferencia implements Transaccion{


    @Override
    public boolean transaccionOk() {
        System.out.println("Se realizo transferiencia");

        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        System.out.println("No se realizo transferiencia");
        return false;
    }
}
