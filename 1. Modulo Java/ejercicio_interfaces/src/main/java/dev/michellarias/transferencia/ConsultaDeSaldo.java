package dev.michellarias.transferencia;

import dev.michellarias.cliente.Cliente;

public class ConsultaDeSaldo extends Transaccion {

    @Override
    public String transaccionOk(Cliente cliente, Transaccion transaccion) {
        return "";
    }

    @Override
    public String transaccionNoOk(Cliente cliente, Transaccion transaccion) {
        return "No se puede realizar la transaccion";
    }
}
