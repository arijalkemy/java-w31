package dev.michellarias.cliente;

import dev.michellarias.transferencia.Transaccion;

public abstract class Cliente {

    protected String nombre;
    protected Double saldo;
    protected String dni;


    Cliente(String nombre, Double saldo, String dni) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.dni = dni;
    }

    public abstract String ejecutarTransaccion(Cliente cliente, Transaccion transaccion);
}
