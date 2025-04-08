package org.meli.transacciones;

import org.meli.Transaccion;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose el Depósito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No pudo realizarse el Depósito");
    }
}