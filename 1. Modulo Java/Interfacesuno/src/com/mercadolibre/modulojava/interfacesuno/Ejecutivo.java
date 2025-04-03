package com.mercadolibre.modulojava.interfacesuno;

public class Ejecutivo {
    private Deposito deposito=new Deposito();
    private Transferencia transferencia=new Transferencia();
    public Ejecutivo(){

    }
    public void hacerDeposito(Boolean x){
        if(x){
            deposito.transaccionOk();

        }else{
            deposito.transaccionNoOk();
        }

    }
    public void hacerTransferencia(Boolean x){
        if(x){
            transferencia.transaccionOk();

        }else{
            transferencia.transaccionNoOk();
        }
    }
}
