package ejerciciouno.models;


import ejerciciouno.interfaces.IConsultaSaldo;
import ejerciciouno.interfaces.IRetiroEfectivo;

public class Cobrador{
    private final IRetiroEfectivo retiroEfectivo;
    private final IConsultaSaldo consultaSaldo;

    public Cobrador(IRetiroEfectivo retiroEfectivo, IConsultaSaldo consultaSaldo) {
        System.out.println("\tCobrador");
        this.retiroEfectivo = retiroEfectivo;
        this.consultaSaldo = consultaSaldo;
    }

    public void retirarEfectivo(){
        this.retiroEfectivo.retirarEfectivo();
    }

    public void estadoRetirarEfectivo() {
        this.retiroEfectivo.transaccionOk();
    }

    public void consultarSaldo() {
        this.consultaSaldo.consultarSaldo();
    }

    public void estadoConsultarSaldo() {
        this.consultaSaldo.transaccionOk();
    }
}
