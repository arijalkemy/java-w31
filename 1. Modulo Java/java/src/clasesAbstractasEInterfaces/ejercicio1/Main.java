package clasesAbstractasEInterfaces.ejercicio1;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------SISTEMA DE TRANSACCION----------");
        Ejecutivo ejecutivo = new Ejecutivo();
        ITransaccion deposito = new Deposito();
        ITransaccion transferencia = new Transferencia();
        ITransaccion consultarSaldo = new ConsultarSaldo();
        ejecutivo.realizarTransferencia(deposito);
        ejecutivo.realizarTransferencia(transferencia);
        ejecutivo.realizarTransferencia(consultarSaldo);

        //Otra solución es hacer clases ejecutivo, basico y cobrador. Y todas las transacciones hacerlas individualmente interfaces
        /*System.out.println("-----BANCO INTERFACES DEL PAÍS-----");
                Ejecutivo ejec = new Ejecutivo();
                ejec.hacerDeposito();
                ejec.hacerTransferencia();
                ejec.transaccionNoOk("Depósito");
                ejec.transaccionOk("Transferencia");*/
    }
}
