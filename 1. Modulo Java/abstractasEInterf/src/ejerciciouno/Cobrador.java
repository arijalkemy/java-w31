package ejerciciouno;

import ejerciciouno.interfaces.ConsultaSaldo;
import ejerciciouno.interfaces.RetiroEfectivo;

public class Cobrador extends ResultadoTransaccion implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void consultar() {
        System.out.println("Se realizo correctamente la consulta del saldo");
    }

    @Override
    public void retirar() {
        System.out.println("Se realizo correctamente el retiro del saldo");
    }
}
