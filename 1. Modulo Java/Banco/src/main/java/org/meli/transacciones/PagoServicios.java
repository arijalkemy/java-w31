package org.meli.transacciones;

import org.meli.Transaccion;

public class PagoServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose el Pago de Servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No pudo realizarse el Pago de Servicios");
    }
}