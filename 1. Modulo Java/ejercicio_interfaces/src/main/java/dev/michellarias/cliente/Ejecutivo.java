package dev.michellarias.cliente;

import dev.michellarias.transferencia.Deposito;
import dev.michellarias.transferencia.Transaccion;
import dev.michellarias.transferencia.Transferencia;

public class Ejecutivo extends Cliente {

    public Ejecutivo(String nombre, Double saldo, String dni) {
        super(nombre, saldo, dni);
    }

    @Override
    public String ejecutarTransaccion(Cliente cliente, Transaccion transaccion) {

        return switch (transaccion){
            case Deposito deposito -> transaccion.transaccionOk(cliente, deposito);
            case Transferencia transferencia -> transaccion.transaccionOk(cliente, transferencia);
            default -> transaccion.transaccionNoOk(cliente, transaccion);
        };
    }
}
