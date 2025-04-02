package dev.michellarias;

import dev.michellarias.cliente.Basico;
import dev.michellarias.cliente.Cliente;
import dev.michellarias.cliente.Cobradores;
import dev.michellarias.cliente.Ejecutivo;
import dev.michellarias.transferencia.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Cliente michell = new Ejecutivo("Michell", 2332D, "12321");
        Cliente hellen = new Cobradores("Hellen", 32322D, "12321");
        Cliente johan = new Cobradores("Johan", 42131D, "12321");
        Cliente felipe = new Basico("Felipe", 5000D, "12321");
        Cliente cristian = new Basico("Cristian", 1321D, "12321");

        Transaccion transaccion = new Deposito();
        String response = michell.ejecutarTransaccion(michell, transaccion);
        System.out.println(response);

        Transaccion consultaDeSaldo = new ConsultaDeSaldo();
        String response2 = hellen.ejecutarTransaccion(hellen, consultaDeSaldo);
        System.out.println(response2);

        Transaccion pagoDeServicios = new PagoDeServicios();
        String response3 = hellen.ejecutarTransaccion(johan, pagoDeServicios);
        System.out.println(response3);

        Transaccion retiroEfectivo = new RetiroEfectivo();
        String response4 = hellen.ejecutarTransaccion(felipe, retiroEfectivo);
        System.out.println(response4);

        Transaccion transaferencia = new Transferencia();
        String response5 = hellen.ejecutarTransaccion(cristian, transaferencia);
        System.out.println(response5);


    }
}