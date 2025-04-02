package dev.michellarias.transferencia;

import dev.michellarias.cliente.Cliente;

public class Deposito extends Transaccion {

    @Override
    public String transaccionOk(Cliente cliente, Transaccion transaccion) {
        return "Deposito OK";
    }

    @Override
    public String transaccionNoOk(Cliente cliente, Transaccion transaccion) {
        return "Deposito NO OKx|";
    }
}
