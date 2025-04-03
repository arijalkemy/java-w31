package ClasesAbstractaseInterfaces.Ejercicio1;

/*
 * Un banco tiene diferentes tipos de transacciones que puede llevar a cabo, entre
 * ellas se encuentran: Depósito, Transferencia, Retiro de Efectivo, Consulta de
 * Saldo, Pago de Servicios. Todas las transacciones tienen dos métodos en común,
 * que son transaccionOk() y transaccionNoOk().
 * 
 * A partir de esto existen diferentes tipos de clientes que pueden interactuar con
 * el banco:
 *  - Ejecutivos: Realizan Depósitos y Transferencias.
 *  - Básico: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
 *  - Cobradores: Realizan retiro de efectivo y consulta de saldos.
 * 
 * Implementar el escenario según corresponda para permitir a los clientes
 * mencionados con anterioridad, el acceso a los diferentes métodos según la
 * operación que deseen realizar.
 * 
 * Notas a tener en cuenta:
 *  - No es necesario implementar cálculos o funciones matemáticas. Los métodos pueden
 *    ser implementaciones de mensajes mediante System.out.println. Por ejemplo, al
 *    hacer un depósito, que aparezca el mensaje “Realizándose depósito”.
 *  - Basic, Cobrador y Ejecutivos pueden ser tratados como clases.
 *  - Transacción puede ser tratada como una Interfaz. Tener en cuenta que existen
 *    diferentes tipos de transacciones que implementarán esta interfaz principal.
 */
public class Main {
    public static void main(String[] args) {
        // Creación de clientes
        Ejecutivo ejecutivo = new Ejecutivo("Pedro", "Fernández");
        Basico basico = new Basico("Julián", "González");
        Cobrador cobrador = new Cobrador("Lucía", "Martínez");


        // Ejecutando transacciones de acuerdo a los tipos de clientes
        System.out.println("\n--- Transacciones del Cliente Ejecutivo ---");
        ejecutivo.realizarDeposito(1000.0);
        ejecutivo.realizarTransferencia(500.0, basico);
        ejecutivo.realizarTransferencia(200.0, cobrador);

        System.out.println("\n--- Transacciones del Cliente Básico ---");
        basico.consultaSaldo();
        basico.pagarServicios(200.0);
        basico.retirarEfectivo(150.0);

        System.out.println("\n--- Transacciones del Cobrador ---");
        cobrador.realizarRetiroEfectivo(100.0);
        cobrador.consultarSaldo();
    }
}
