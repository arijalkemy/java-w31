package ejerciciouno;

import ejerciciouno.interfaces.*;

public class ResultadoTransaccion implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("La transaccion salio Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transaccion fallo");

    }
}
