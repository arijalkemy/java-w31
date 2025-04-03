package com.company;

public class Basico extends Cliente {

    private Integer operacionesMensuales;


    public Basico(String nombre, String dni, Integer operacionesMensuales) {
        super(nombre, dni);
        this.operacionesMensuales = operacionesMensuales;
    }

    public Integer getOperacionesMensuales() {
        return operacionesMensuales;
    }

    public void setOperacionesMensuales(Integer operacionesMensuales) {
        this.operacionesMensuales = operacionesMensuales;
    }

    @Override
    public void realizarOperacion(Transaccion t) {
        if( t instanceof PagarServicio || t instanceof ConsultarSaldo || t instanceof RetiroEnEfectivo){
            t.transaccionNoOk();
        }else{
            System.out.println("Operación no autorizada");
        }

    }
}
