package dev.michellarias.cliente;

import dev.michellarias.transferencia.Transaccion;

public abstract class Cliente {

    protected String nombre;
    protected double saldo;
    protected String dni;


    public abstract String ejecutarTransaccion(Cliente cliente, Transaccion transaccion);
}
