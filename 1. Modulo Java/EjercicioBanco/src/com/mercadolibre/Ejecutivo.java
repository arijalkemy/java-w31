package com.mercadolibre;

public class Ejecutivo extends Cliente{


    public Ejecutivo(Double saldoEnCuenta) {
        super(saldoEnCuenta);
    }

    public void realizarDeposito(Double dineroAIngresar){
        Deposito deposito = new Deposito(this);
        deposito.realizarDeposito(dineroAIngresar);
        System.out.println("Se realizó el depósito, saldo actual: " + this.getSaldoEnCuenta());
    }

    public void realizarTransferencia(Double dineroATransferir){
        Transferencia transferencia = new Transferencia(this);
        transferencia.realizarTransferencia(dineroATransferir);
        System.out.println("Saldo actual: " + this.getSaldoEnCuenta());
    }
}
