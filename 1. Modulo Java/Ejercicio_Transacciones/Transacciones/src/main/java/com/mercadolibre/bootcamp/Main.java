package com.mercadolibre.bootcamp;

import com.mercadolibre.bootcamp.model.Basic;
import com.mercadolibre.bootcamp.model.Cobrador;
import com.mercadolibre.bootcamp.model.Ejecutivo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("----- Servicio Transaccional AC -----");
        Basic clienteBasico = new Basic();
        clienteBasico.consultaSaldo();
        clienteBasico.pagarServicio("Agua");
        clienteBasico.hacerRetiro(100D);
        clienteBasico.transaccionOk("Retiro");
        clienteBasico.transaccionNotOk("Pago Retiro");

        Cobrador cobrador = new Cobrador();
        cobrador.consultaSaldo();
        cobrador.hacerRetiro(100D);
        cobrador.transaccionOk("Retiro");
        cobrador.transaccionNotOk("Pago Retiro");

    }
}