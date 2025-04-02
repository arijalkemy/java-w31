package com.mercadolibre.bootcamp.model;


import com.mercadolibre.bootcamp.interfaces.ConsultaSaldo;
import com.mercadolibre.bootcamp.interfaces.Retiro;

public class Cobrador extends Cliente implements Retiro, ConsultaSaldo {

    @Override
    public void hacerRetiro(Double valor) {
        System.out.println("Retirando fondos.." +  valor);
    }

    @Override
    public void consultaSaldo() {
        System.out.println("Consultando Saldo...");
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
