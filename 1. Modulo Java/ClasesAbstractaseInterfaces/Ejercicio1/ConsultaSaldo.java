package ClasesAbstractaseInterfaces.Ejercicio1;

public class ConsultaSaldo implements Transaccion {
    Cliente cliente;

    public ConsultaSaldo(Cliente cliente) {
        this.cliente = cliente;
    }

    public double consultarSaldo() {
        System.out.println("Consultando saldo de " + cliente.getNombre() + " " + cliente.getApellido());
        return cliente.getDineroEnCuenta();
    }

    @Override
    public boolean transaccionOk() {
        return true; // La consulta de saldo siempre es exitosa
    }

    @Override
    public boolean transaccionNoOk() {
        return false; // La consulta de saldo nunca es fallida
    }
}
