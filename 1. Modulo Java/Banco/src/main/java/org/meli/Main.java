package org.meli;

import org.meli.clientes.Basico;
import org.meli.clientes.Cobrador;
import org.meli.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Ejecutivo ===");
        Ejecutivo.realizarDeposito();
        Ejecutivo.realizarTransferencia();
        Ejecutivo.realizarRetiroEfectivo();
        Ejecutivo.realizarConsultaSaldo();
        Ejecutivo.realizarPagoServicios();
        System.out.println();

        System.out.println("=== Básico ===");
        Basico.realizarDeposito();
        Basico.realizarTransferencia();
        Basico.realizarRetiroEfectivo();
        Basico.realizarConsultaSaldo();
        Basico.realizarPagoServicios();
        System.out.println();

        System.out.println("=== Cobrador ===");
        Cobrador.realizarDeposito();
        Cobrador.realizarTransferencia();
        Cobrador.realizarRetiroEfectivo();
        Cobrador.realizarConsultaSaldo();
        Cobrador.realizarPagoServicios();
        System.out.println();

    }
}