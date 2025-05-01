public class Cobrador {
    public void consultarSaldo() {
        new ConsultaSaldo().transaccionOk();
    }

    public void retirarEfectivo() {
        new RetiroEfectivo().transaccionOk();
    }
}
