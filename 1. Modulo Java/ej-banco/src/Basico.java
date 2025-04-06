public class Basico extends TransaccionManager implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {

    @Override
    public void realizarConsultaDeSaldo() {
        System.out.println("Realizando consulta de saldo...");
        transaccionOk();
    }

    @Override
    public void realizarPagoDeServicios() {
        System.out.println("Realizando pago de servicios...");
        transaccionOk();
    }

    @Override
    public void realizarRetiroDeEfectivo() {
        System.out.println("Realizando retiro de efectivo...");
        transaccionOk();
    }
}
