package com.mercadolibre;

public class Transferencia extends Transaccion{

    public Transferencia(Cliente cliente) {
        super(cliente);
    }

    public void realizarTransferencia(Double dineroATransferir){
        if(this.cliente.getSaldoEnCuenta() >= dineroATransferir){
            this.cliente.setSaldoEnCuenta(this.cliente.getSaldoEnCuenta() - dineroATransferir);
            System.out.println(transaccionOk());
        } else {
            System.out.println(transaccionNoOk());
        }
    }
}
