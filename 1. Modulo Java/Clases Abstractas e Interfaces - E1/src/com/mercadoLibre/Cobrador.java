package com.mercadoLibre;

public class Cobrador implements Transaccion{
    private double saldo;

    public Cobrador(double saldo) {
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
        System.out.println("Retiro exitoso! Saldo en cuenta $" + saldo);
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Error");
    }


    public void retiroEfecivo(double cantidadRetirar) {
        if (cantidadRetirar > this.saldo) {
            transaccionNotOk();
        } else {
                saldo =- cantidadRetirar;
                transaccionOk();
            }
        }

    public void consultarSaldo() {
        System.out.println(saldo);
    }
}
