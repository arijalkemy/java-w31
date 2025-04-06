public class Cobradores extends TransaccionManager implements RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public void realizarConsultaDeSaldo() {
        System.out.println("Realizando consulta de saldo...");
        transaccionOk();
    }

    @Override
    public void realizarRetiroDeEfectivo() {
        System.out.println("Realizando retiro de efectivo...");
        transaccionOk();
    }
}
