package main.java;

public class Cobrador {
    public void realizarConsultaSaldo() {
        ConsultaSaldo consulta = new ConsultaSaldo();
        consulta.transaccionOk();
    }

    public void realizarRetiroEfectivo() {
        RetiroEfectivo retiro = new RetiroEfectivo();
        retiro.transaccionOk();
    }
}
