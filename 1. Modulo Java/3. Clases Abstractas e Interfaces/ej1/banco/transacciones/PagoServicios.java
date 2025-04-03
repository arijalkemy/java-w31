package banco.transacciones;

import java.math.BigDecimal;

import banco.clientes.Cliente;

public class PagoServicios implements Transaccion {

    public void pagarServicio(BigDecimal monto, String servicio, Cliente cliente) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0 || servicio == null || servicio.isBlank()) {
            transaccionNoOk();
        }

        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.retirarEfectivo(monto, cliente);
        transaccionOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios exitoso. Su pago ha sido procesado.");
    }

    @Override
    public void transaccionNoOk() {
        throw new RuntimeException("Pago de servicios fallido. No se pudo procesar el pago.");
    }
}