package dev.michellarias.transferencia;

import dev.michellarias.cliente.Cliente;

public interface ITransaccionable {
    String transaccionOk(Cliente cliente, Transaccion transaccion);
    String transaccionNoOk(Cliente cliente, Transaccion transaccion);

}
