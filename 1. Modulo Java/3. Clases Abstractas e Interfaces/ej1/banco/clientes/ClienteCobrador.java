package banco.clientes;

import java.math.BigDecimal;

import banco.transacciones.ConsultaSaldo;
import banco.transacciones.RetiroEfectivo;

public class ClienteCobrador extends Cliente {

    public ClienteCobrador(String nombreCompleto, int edad, BigDecimal saldo) {
        super(nombreCompleto, edad, saldo);
    }

    public void retirarEfectivo(BigDecimal monto) {
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        if (monto.compareTo(getSaldo()) > 0) {
            throw new IllegalArgumentException("Fondos insuficientes.");
        }
        setSaldo(getSaldo().subtract(monto));
        retiroEfectivo.transaccionOk();
    }

    public void consultarSaldo() {
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.consultarSaldo(this);
    }
}
