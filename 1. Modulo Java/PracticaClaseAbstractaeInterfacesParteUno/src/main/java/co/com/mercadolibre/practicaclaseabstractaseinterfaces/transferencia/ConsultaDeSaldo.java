package co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia;

import co.com.mercadolibre.practicaclaseabstractaseinterfaces.cliente.Cliente;

public class ConsultaDeSaldo extends Transaccion {

    @Override
    public String transaccionOk(Cliente cliente, Transaccion transaccion) {
        return "Consultando saldo del Cliente... Exitoso";
    }

    @Override
    public String transaccionNoOk(Cliente cliente, Transaccion transaccion) {
        return "No se puede realizar la consulta de saldo del Cliente";
    }
}
