package com.mercadolibre.modulojava.interfacesuno;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.hacerDeposito(true);
        ejecutivo.hacerDeposito(false);
        Basic basic = new Basic();
        basic.consultarSaldo(true);
        basic.retiroEfectivo(false);
        basic.pagarServicios(false);
        Cobrador cobrador = new Cobrador();
        cobrador.consultarSaldo(true);
        cobrador.retiroEfectivo(true);


        }

    }
