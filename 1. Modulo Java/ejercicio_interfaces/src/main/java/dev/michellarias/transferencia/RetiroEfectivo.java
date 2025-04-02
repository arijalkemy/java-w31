package dev.michellarias.transferencia;

import dev.michellarias.cliente.Cliente;

public class RetiroEfectivo extends Transaccion{

    @Override
    public String transaccionOk(Cliente cliente, Transaccion transaccion) {
        return "Realizando retiro de efectivo... OK";
    }

    @Override
    public String transaccionNoOk(Cliente cliente, Transaccion transaccion) {
        return "Retiro de efectivo no exitoso";
    }
}
