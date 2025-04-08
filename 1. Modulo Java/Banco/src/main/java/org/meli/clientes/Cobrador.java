package org.meli.clientes;

import org.meli.Transaccion;
import org.meli.transacciones.*;

public class Cobrador {
    public static void realizarRetiroEfectivo() {
        Transaccion transaccion = new RetiroEfectivo();
        transaccion.transaccionOk();
    }

    public static void realizarConsultaSaldo() {
        Transaccion transaccion = new ConsultaSaldo();
        transaccion.transaccionOk();
    }

    public static void realizarDeposito() {
        Transaccion transaccion = new Deposito();
        transaccion.transaccionNoOk();
    }

    public static void realizarTransferencia() {
        Transaccion transaccion = new Transferencia();
        transaccion.transaccionNoOk();
    }

    public static void realizarPagoServicios() {
        Transaccion transaccion = new PagoServicios();
        transaccion.transaccionNoOk();
    }
}