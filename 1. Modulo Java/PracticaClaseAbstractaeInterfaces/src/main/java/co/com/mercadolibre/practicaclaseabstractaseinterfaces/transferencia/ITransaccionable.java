package co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia;

import co.com.mercadolibre.practicaclaseabstractaseinterfaces.cliente.Cliente;

public interface ITransaccionable {

    String transaccionOk(Cliente cliente, Transaccion transaccion);
    String transaccionNoOk(Cliente cliente, Transaccion transaccion);
}
