package com.company;

public class Ejecutivo implements Deposito, Transferencia{

    @Override
    public Boolean transaccionOk() {
        System.out.println("La transaccion se realizó con exito" );
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("La transaccion no pudo realizarse" );
        return false;
    }

    @Override
    public void hacerDeposito(Double monto) {
        System.out.println("Realizando deposito de "+ monto);
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia");

    }
}
