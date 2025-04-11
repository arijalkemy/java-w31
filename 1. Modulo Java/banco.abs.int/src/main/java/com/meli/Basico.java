package com.meli;

public class Basico {
    Operacion operacion = new Operacion();

    public void realizarConsulta() {
        operacion.consulta();
    }
    public void realizarPagoDeServicios() {
        operacion.pago();
    }
    public void retirarEfectivo() {
        operacion.retiro();
    }
}
