package dev.michellarias.transferencia;

import dev.michellarias.cliente.Cliente;

public class RetiroEfectivo extends Transaccion{

    @Override
    public String transaccionOk(Cliente cliente, Transaccion transaccion) {
        return "";
    }

    @Override
    public String transaccionNoOk(Cliente cliente, Transaccion transaccion) {
        return "";
    }
}
