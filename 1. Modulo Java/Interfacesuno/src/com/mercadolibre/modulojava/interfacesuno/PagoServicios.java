package com.mercadolibre.modulojava.interfacesuno;

public class PagoServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios exitoso");
    }
    @Override
    public void transaccionNoOk(){
        System.out.println("Pago de servicios fallido");
    }
}
