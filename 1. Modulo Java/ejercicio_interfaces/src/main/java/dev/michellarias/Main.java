package dev.michellarias;

import dev.michellarias.cliente.Cliente;
import dev.michellarias.cliente.Ejecutivo;
import dev.michellarias.transferencia.ConsultaDeSaldo;
import dev.michellarias.transferencia.Deposito;
import dev.michellarias.transferencia.Transaccion;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Ejecutivo();
        Transaccion transaccion = new Deposito();
        String response = cliente.ejecutarTransaccion(cliente, transaccion);
        System.out.println(response);



        Transaccion transaccion2 = new ConsultaDeSaldo();
        String response2 = cliente.ejecutarTransaccion(cliente, transaccion2);
        System.out.println("response2 = " + response2);

    }
}