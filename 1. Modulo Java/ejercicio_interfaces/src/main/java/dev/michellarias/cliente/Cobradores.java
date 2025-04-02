package dev.michellarias.cliente;

import dev.michellarias.transferencia.*;

public class Cobradores extends Cliente {

    public Cobradores(String nombre, Double saldo, String dni) {
        super(nombre, saldo, dni);
    }

    @Override
    public String ejecutarTransaccion(Cliente cliente, Transaccion transaccion) {

        return switch (transaccion){
            case RetiroEfectivo retiro -> transaccion.transaccionOk(cliente, retiro);
            case ConsultaDeSaldo consulta -> transaccion.transaccionOk(cliente, consulta);
            default -> transaccion.transaccionNoOk(cliente, transaccion);
        };
    }
}
