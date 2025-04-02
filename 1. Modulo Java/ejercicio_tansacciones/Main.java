package E1;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basico basico = new Basico();
        Colaborador colaborador = new Colaborador();

        System.out.println("El ejecutivo realiza las sigientes acciones:");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();
        ejecutivo.retirarEfectivo();
        ejecutivo.consultarSaldo();
        ejecutivo.pagarServicios();

        System.out.println("El bascio realiza las siguientes acciones:");
        basico.realizarDeposito();
        basico.realizarTransferencia();
        basico.retirarEfectivo();
        basico.consultarSaldo();
        basico.pagarServicios();

        System.out.println("El colaborador realiza las siguientes acciones:");
        colaborador.realizarDeposito();
        colaborador.realizarTransferencia();
        colaborador.retirarEfectivo();
        colaborador.consultarSaldo();
        colaborador.pagarServicios();

    }
}
