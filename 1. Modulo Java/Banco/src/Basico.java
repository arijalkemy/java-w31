public class Basico {
    public void consultarSaldo() {
        new ConsultaSaldo().transaccionOk();
    }

    public void pagarServicios() {
        new PagoServicios().transaccionOk();
    }

    public void retirarEfectivo() {
        new RetiroEfectivo().transaccionOk();
    }
}
