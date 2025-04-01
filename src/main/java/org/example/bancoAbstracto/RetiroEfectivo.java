package org.example.bancoAbstracto;

public class RetiroEfectivo implements Transaccion {

    @Override
    public boolean transaccionOk() {
        System.out.println("Retirando efectivo.");
        return true;
    }

    @Override
    public boolean transaccionNoOK() {
        System.out.println("Error al retirar efectivo.");
        return false;
    }
}
