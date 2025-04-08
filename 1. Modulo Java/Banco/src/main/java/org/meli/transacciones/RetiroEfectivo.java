package org.meli.transacciones;

import org.meli.Transaccion;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose el Retiro de efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No pudo realizarse el Retiro de efectivo");
    }
}