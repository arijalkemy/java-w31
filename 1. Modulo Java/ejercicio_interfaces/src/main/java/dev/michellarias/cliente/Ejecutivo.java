package dev.michellarias.cliente;

import dev.michellarias.transferencia.Deposito;
import dev.michellarias.transferencia.Transaccion;
import dev.michellarias.transferencia.Transferencia;

public class Ejecutivo extends Cliente {

    @Override
    public String ejecutarTransaccion(Cliente cliente, Transaccion transaccion) {

        return switch (transaccion){
            case Deposito d-> transaccion.transaccionOk(cliente, transaccion);
            case Transferencia t -> transaccion.transaccionOk(cliente, transaccion);
            default -> transaccion.transaccionNoOk(cliente, transaccion);
        };

//        if (transaccion instanceof Deposito) {
//            Deposito deposito = (Deposito) transaccion;
//            return deposito.transaccionOk(cliente, transaccion);
//        }
//
//        if (transaccion instanceof Transferencia) {
//            Transferencia transferencia = (Transferencia) transaccion;
//            return transferencia.transaccionOk(cliente, transaccion);
//        }
//
//        return transaccion.transaccionNoOk(cliente, transaccion);
    }
}
