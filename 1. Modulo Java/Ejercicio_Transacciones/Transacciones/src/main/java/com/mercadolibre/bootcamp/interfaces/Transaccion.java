package com.mercadolibre.bootcamp.interfaces;

public interface Transaccion {

    public void transaccionOk(String transaccion);
    public void transaccionNotOk(String transaccion);
}
