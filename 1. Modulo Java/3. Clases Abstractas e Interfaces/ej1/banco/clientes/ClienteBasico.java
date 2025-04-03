package banco.clientes;

import java.math.BigDecimal;

import banco.transacciones.ConsultaSaldo;
import banco.transacciones.PagoServicios;
import banco.transacciones.RetiroEfectivo;

public class ClienteBasico extends Cliente {

    public ClienteBasico(String nombreCompleto, int edad, BigDecimal saldo) {
        super(nombreCompleto, edad, saldo);
    }

    public void consultarSaldo() {
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.consultarSaldo(this);
    }

    public void pagarServicio(BigDecimal monto, String servicio) {
        PagoServicios pagoServicios = new PagoServicios();
        pagoServicios.pagarServicio(monto, servicio, this);
    }

    public void retirarEfectivo(BigDecimal monto) {
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.retirarEfectivo(monto, this);
    }
}
