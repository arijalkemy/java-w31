package com.mercadolibre.modulojava.interfacesuno;

public class Cobrador implements IPagoEfe{
    private RetiroEnEfectivo retiroEnEfectivo=new RetiroEnEfectivo();
    private ConsultaSaldo consultaSaldo=new ConsultaSaldo();

    public void consultarSaldo(Boolean x){
        if(x){
            consultaSaldo.transaccionOk();

        }else{
            consultaSaldo.transaccionNoOk();
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
