package banco.transacciones;

import java.math.BigDecimal;

import banco.clientes.Cliente;

public class Transferencia implements Transaccion {

    public void hacerTransferencia(BigDecimal montoTransferir, Cliente clienteOrigen, Cliente clienteDestino) {
        if (montoTransferir.compareTo(BigDecimal.ZERO) <= 0) {
            transaccionNoOk();
        }

        RetiroEfectivo retiro = new RetiroEfectivo();
        Deposito deposito = new Deposito();

        retiro.retirarEfectivo(montoTransferir, clienteOrigen);
        deposito.hacerDeposito(montoTransferir, clienteDestino);

        transaccionOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia exitosa. Su dinero ha sido transferido.");
    }

    @Override
    public void transaccionNoOk() {
        throw new RuntimeException("Transferencia fallida. No se pudo completar la transferencia.");
    }
}
