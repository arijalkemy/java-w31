package org.meli.transacciones;

import org.meli.Transaccion;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose la Transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No pudo realizarse la Transferencia");
    }
}