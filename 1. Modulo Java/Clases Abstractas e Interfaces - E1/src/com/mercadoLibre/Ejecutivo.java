package com.mercadoLibre;

public class Ejecutivo implements Transaccion {
    private double saldo;

    public Ejecutivo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción exitosa! Saldo en cuenta $" + saldo);
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Error en la transacción. No cuenta con el saldo suficiente en cuenta.");
    }

    public void deposito(double cantidadDepositar) {
        saldo += cantidadDepositar;
        transaccionOk();
    }

    public void transferencia(double cantidadTransferir) {
        if (cantidadTransferir > this.saldo) {
            transaccionNotOk();
        } else {
            saldo =- cantidadTransferir;
            transaccionOk();
        }
    }
}
