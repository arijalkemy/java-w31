package com.meli;

public class Main {
    public static void main(String[] args) {
        Ejecutivo e1 = new Ejecutivo();
        Basico b1 = new Basico();
        Cobradores c1 = new Cobradores();

        System.out.println("Ejecutivo:");
        e1.realizarDeposito();
        e1.realizarTransferencia();

        System.out.println("Cliente Básico:");
        b1.realizarConsulta();
        b1.realizarPagoDeServicios();

     

        System.out.println("Cobrador:");
        c1.realizarConsulta();
        c1.realizarRetiroDeEfectivo();
   
    }
}