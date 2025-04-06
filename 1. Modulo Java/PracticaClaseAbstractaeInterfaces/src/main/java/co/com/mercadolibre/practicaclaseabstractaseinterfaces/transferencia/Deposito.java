package co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia;

import co.com.mercadolibre.practicaclaseabstractaseinterfaces.cliente.Cliente;

public class Deposito extends Transaccion {

    @Override
    public String transaccionOk(Cliente cliente, Transaccion transaccion) {
        return "Deposito OK";
    }

    @Override
    public String transaccionNoOk(Cliente cliente, Transaccion transaccion) {
        return "Deposito no exitoso";
    }

}
