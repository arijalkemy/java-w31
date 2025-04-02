package com.mercadolibre;

public class RetiroEfectivo extends Transaccion {

    public RetiroEfectivo(Cliente cliente) {
        super(cliente);
    }

    public void retirarEfectivo(Double dineroARetirar) {
        if (this.cliente.getSaldoEnCuenta() >= dineroARetirar) {
            this.cliente.setSaldoEnCuenta(this.cliente.getSaldoEnCuenta() - dineroARetirar);
            System.out.println(transaccionOk());
        } else {
            System.out.println(transaccionNoOk());
        }
    }
}
