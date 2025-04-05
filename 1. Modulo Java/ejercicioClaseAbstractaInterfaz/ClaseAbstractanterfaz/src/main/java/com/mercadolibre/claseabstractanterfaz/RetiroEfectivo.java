package main.java;

public class RetiroEfectivo implements Transaccion{
    @Override
    public boolean transaccionOk() {
        System.out.println("Se retiro efectivo");
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        System.out.println("No se retiro efectivo");
        return false;
    }
}
