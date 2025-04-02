package dev.michellarias.cliente;

import dev.michellarias.transferencia.*;

public class Basico extends Cliente {

    public Basico(String nombre, Double saldo, String dni) {
        super(nombre, saldo, dni);
    }

    @Override
    public String ejecutarTransaccion(Cliente cliente, Transaccion transaccion) {

        return switch (transaccion){
            case ConsultaDeSaldo consulta -> transaccion.transaccionOk(cliente, consulta);
            case PagoDeServicios pagos -> transaccion.transaccionOk(cliente, pagos);
            case RetiroEfectivo retiro -> transaccion.transaccionOk(cliente, retiro);
            default -> transaccion.transaccionNoOk(cliente, transaccion);
        };
    }
}
