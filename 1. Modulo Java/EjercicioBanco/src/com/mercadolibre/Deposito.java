package com.mercadolibre;

public class Deposito extends Transaccion {


    public Deposito(Cliente cliente) {
        super(cliente);
    }

    public void realizarDeposito(Double dineroADepositar){
        this.cliente.setSaldoEnCuenta(this.cliente.getSaldoEnCuenta() + dineroADepositar);
        System.out.println(transaccionOk());
    }


}