package ejerciciouno.services;


import ejerciciouno.interfaces.IConsultaSaldo;

public class ConsultaSaldo implements IConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Consultar saldo - Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consultar saldo - Transaccion no ok");
    }

}
