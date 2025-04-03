package com.company;

public class Ejecutivo extends Cliente{

    private Integer limiteTransfenciaDiaria;


    public Ejecutivo(String nombre, String dni) {
        super(nombre, dni);
    }

    public Integer getLimiteTransfenciaDiaria() {
        return limiteTransfenciaDiaria;
    }

    public void setLimiteTransfenciaDiaria(Integer limiteTransfenciaDiaria) {
        this.limiteTransfenciaDiaria = limiteTransfenciaDiaria;
    }

    @Override
    public void realizarOperacion(Transaccion t) {
        if(t instanceof Depositar || t instanceof Transferencia){
            t.transaccionOk();
        }else{
            System.out.println("Operacion no autorizada");
        }
    }


}
