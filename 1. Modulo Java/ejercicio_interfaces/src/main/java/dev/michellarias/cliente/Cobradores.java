package dev.michellarias.cliente;

import dev.michellarias.transferencia.Transaccion;

public class Cobradores extends Cliente {

    @Override
    public String ejecutarTransaccion(Cliente cliente, Transaccion transaccion) {
        return "";
    }
}
