package com.meli;

public class Ejecutivo {
    Operacion operacion = new Operacion();

    public void realizarDeposito(){
        operacion.deposito();
    }
    public void realizarTransferencia(){
        operacion.transferencia();
    }

}
