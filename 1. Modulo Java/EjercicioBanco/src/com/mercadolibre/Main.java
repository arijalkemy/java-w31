package com.mercadolibre;

public class Main {
    public static void main (String[]args){
        Ejecutivo ejecutivo = new Ejecutivo(0.0);
        ejecutivo.realizarDeposito(70000.0);
        ejecutivo.realizarTransferencia(3000.0);
        //Para el fallo
        ejecutivo.realizarTransferencia(80000.0);

        System.out.println("*-----------------------------*");
        Cobrador c = new Cobrador(80000.0);
        c.consultarSaldo();
        c.retirarEfectivo(70000.0);
        //Para el fallo
        c.retirarEfectivo(20000.0);

        System.out.println("*-----------------------------*");
        Basico b = new Basico(150000.0);
        b.consultarSaldo();
        b.retirarDinero(30000.0);
        //Para el fallo
        b.retirarDinero(170000.0);
        b.pagarServicio(10000.0);
        //Para el fallo
        b.pagarServicio(180000.0);
    }

}
