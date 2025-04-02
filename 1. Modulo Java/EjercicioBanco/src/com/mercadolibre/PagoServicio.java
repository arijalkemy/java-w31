package com.mercadolibre;

public class PagoServicio extends Transaccion {

    public PagoServicio(Cliente cliente) {
        super(cliente);
    }

    public void realizarPago(Double dineroAPagar) {
        if (this.cliente.getSaldoEnCuenta() >= dineroAPagar) {
            this.cliente.setSaldoEnCuenta(this.cliente.getSaldoEnCuenta() - dineroAPagar);
            System.out.println(transaccionOk());
        } else {
            System.out.println(transaccionNoOk());
        }
    }
}
