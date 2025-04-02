package dev.michellarias.transferencia;

import dev.michellarias.cliente.Cliente;

public class Transferencia extends Transaccion{

    @Override
    public String transaccionOk(Cliente cliente, Transaccion transaccion) {
        return "Transferencia realizada con exito";
    }

    @Override
    public String transaccionNoOk(Cliente cliente, Transaccion transaccion) {
        return "Transferencia fallida";
    }
}
