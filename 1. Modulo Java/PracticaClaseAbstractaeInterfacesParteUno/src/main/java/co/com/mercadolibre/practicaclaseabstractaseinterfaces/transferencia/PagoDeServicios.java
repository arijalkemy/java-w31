package co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia;

import co.com.mercadolibre.practicaclaseabstractaseinterfaces.cliente.Cliente;

public class PagoDeServicios extends Transaccion {

    @Override
    public String transaccionOk(Cliente cliente, Transaccion transaccion) {
        return "Pago de servicios realizado con exito";
    }

    @Override
    public String transaccionNoOk(Cliente cliente, Transaccion transaccion) {
        return "Pago de servicios ha fallado";
    }
}
