package org.meli.transacciones;

import org.meli.Transaccion;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose la Consulta de Saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No pudo realizarse la Consulta de Saldo");
    }
}