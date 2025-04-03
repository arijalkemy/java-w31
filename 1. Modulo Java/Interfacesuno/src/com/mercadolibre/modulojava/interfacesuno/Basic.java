package com.mercadolibre.modulojava.interfacesuno;

public class Basic implements IPagoEfe {
    private ConsultaSaldo consultaSaldo=new ConsultaSaldo();
    private PagoServicios pagoServicios=new PagoServicios();
    private RetiroEnEfectivo retiroEnEfectivo=new RetiroEnEfectivo();

    public void consultarSaldo(Boolean x){
        if(x){
            consultaSaldo.transaccionOk();

        }else{
            consultaSaldo.transaccionNoOk();
        }

    }
    public void pagarServicios(Boolean x){
        if(x){
            pagoServicios.transaccionOk();

        }else{
            pagoServicios.transaccionNoOk();
        }

    }


    @Override
    public void retiroEfectivo(Boolean x) {
        if(x){
            retiroEnEfectivo.transaccionOk();

        }else{
            retiroEnEfectivo.transaccionNoOk();
        }
    }
}
