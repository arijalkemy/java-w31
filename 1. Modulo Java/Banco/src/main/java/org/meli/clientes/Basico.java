package org.meli.clientes;

import org.meli.Transaccion;
import org.meli.transacciones.*;

public class Basico {
    public static void realizarConsultaSaldo() {
        Transaccion consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaccionOk();
    }

    public static void realizarPagoServicios() {
        Transaccion pagoServicios = new PagoServicios();
        pagoServicios.transaccionOk();
    }

    public static void realizarRetiroEfectivo() {
        Transaccion retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionOk();
    }

    public static void realizarDeposito() {
        Transaccion deposito = new Deposito();
        deposito.transaccionNoOk();
    }

    public static void realizarTransferencia() {
        Transaccion transferencia = new Transferencia();
        transferencia.transaccionNoOk();
    }
}