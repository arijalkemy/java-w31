package org.meli.clientes;

import org.meli.Transaccion;
import org.meli.transacciones.*;

public class Ejecutivo {
    public static void realizarDeposito() {
        Transaccion deposito = new Deposito();
        deposito.transaccionOk();
    }

    public static void realizarTransferencia() {
        Transaccion transferencia = new Transferencia();
        transferencia.transaccionOk();
    }

    public static void realizarRetiroEfectivo() {
        Transaccion retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionNoOk();
    }

    public static void realizarConsultaSaldo() {
        Transaccion consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaccionNoOk();
    }

    public static void realizarPagoServicios() {
        Transaccion pagoServicios = new PagoServicios();
        pagoServicios.transaccionNoOk();
    }
}