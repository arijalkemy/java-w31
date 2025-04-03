package main.java;

public class Basico {
    public void consultaSaldo(){
        ConsultaSaldo consultaDeSaldo = new ConsultaSaldo();
        consultaDeSaldo.transaccionOk();
    }
    public void  pagoDeServicos(){
        PagoServicio pagoServicios = new PagoServicio();

        pagoServicios.transaccionOk();
    }
    public void retirarEfectivo(){
        RetiroEfectivo retiroDeEfectivo = new RetiroEfectivo();
        retiroDeEfectivo.transaccionOk();
    }
}
