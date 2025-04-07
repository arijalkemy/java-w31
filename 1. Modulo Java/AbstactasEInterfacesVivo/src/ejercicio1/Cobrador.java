package ejercicio1;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo{
    @Override
    public void hacerConsultaSaldo() {
        System.out.println("Consultando Saldo....");
    }

    @Override
    public void hacerRetiroEfectivo(Double montoRetirado) {
        System.out.println("Intentando retirar: " + montoRetirado);
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Intentando hacer transferencia...");
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo concluir");
    }
}
