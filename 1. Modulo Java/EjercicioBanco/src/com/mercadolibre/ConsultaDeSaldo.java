package com.mercadolibre;

public class ConsultaDeSaldo extends Transaccion{
    public ConsultaDeSaldo(Cliente cliente) {
        super(cliente);
    }

    public Double consultarSaldo(){
        System.out.println(transaccionOk());
        return this.cliente.getSaldoEnCuenta();
    }
}
