package com.mercadoLibre;

public class Basico implements Transaccion{

    double saldo;

    public Basico(double saldo) {
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

    public void pagoServicios(double cantidadPagar) {
        if (cantidadPagar > this.saldo) {
            transaccionNotOk();
        } else {
            saldo =- cantidadPagar;
            transaccionOk();
        }
    }
}
