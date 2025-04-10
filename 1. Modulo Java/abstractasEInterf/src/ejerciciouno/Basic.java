package ejerciciouno;

import ejerciciouno.interfaces.ConsultaSaldo;
import ejerciciouno.interfaces.PagoServicio;
import ejerciciouno.interfaces.RetiroEfectivo;

public class Basic extends ResultadoTransaccion implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    @Override
    public void consultar() {
        System.out.println("Se realizo correctamente la consulta del saldo");

    }

    @Override
    public void pagar() {
        System.out.println("Se realizo correctamente el pago");

    }

    @Override
    public void retirar() {
        System.out.println("Se realizo correctamente el retiro del saldo");
    }
}
