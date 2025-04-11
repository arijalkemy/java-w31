package com.meli;

public class Cobradores {
    Operacion operacion = new Operacion();

    public void realizarRetiroDeEfectivo() {
        operacion.retiro();
    }
    public void realizarConsulta() {
        operacion.consulta();
    }

}
