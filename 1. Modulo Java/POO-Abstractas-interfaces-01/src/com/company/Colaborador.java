package com.company;

public class Colaborador extends Cliente{
    private String tipoColaboración;


    public Colaborador(String nombre, String dni,String tipoColaboración) {
        super(nombre, dni);
        this.tipoColaboración = tipoColaboración;
    }

    public String getTipoColaboración() {
        return tipoColaboración;
    }

    public void setTipoColaboración(String tipoColaboración) {
        this.tipoColaboración = tipoColaboración;
    }


    @Override
    public void realizarOperacion(Transaccion t) {
        if(t instanceof RetiroEnEfectivo || t instanceof ConsultarSaldo){
            t.transaccionOk();
        }else{
            System.out.println("Operación no autorizada");
        }
    }
}
