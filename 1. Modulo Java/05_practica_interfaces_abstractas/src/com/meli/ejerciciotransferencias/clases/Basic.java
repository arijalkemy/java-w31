package com.meli.ejerciciotransferencias.clases;

import com.meli.ejerciciotransferencias.interfaces.ConsultaDeSaldo;
import com.meli.ejerciciotransferencias.interfaces.PagoDeServicios;
import com.meli.ejerciciotransferencias.interfaces.RetiroDeEfectivo;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {
    @Override
    public void consultarSaldo() {

    }

    @Override
    public void pagarServicios() {

    }

    @Override
    public void retirarEfectivo() {

    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
