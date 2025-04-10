package ejerciciouno;

import ejerciciouno.interfaces.Deposito;
import ejerciciouno.interfaces.Transferencia;

public class Ejecutivo extends ResultadoTransaccion implements Deposito, Transferencia {

    @Override
    public void depositar() {
        System.out.println("Se realizo el deposito correctamente");
    }

    @Override
    public void transferir() {
        System.out.println("Se realizo la transferencia correctamene");
    }
}
