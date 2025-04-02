package com.mercadolibre.bootcamp.model;


import com.mercadolibre.bootcamp.interfaces.Deposito;
import com.mercadolibre.bootcamp.interfaces.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {


    @Override
    public void hacerDeposito() {
        System.out.println("Depositos de Ejecutivo");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Transferencia de Ejecutivo");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transacción " + transaccion + " realizada exitosamente");
    }

    @Override
    public void transaccionNotOk(String transaccion) {
        System.out.println(transaccion + " no realizada.");
    }


}
