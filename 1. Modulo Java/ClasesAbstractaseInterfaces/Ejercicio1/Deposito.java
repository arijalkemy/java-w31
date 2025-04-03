package ClasesAbstractaseInterfaces.P1.Ejercicio1;

public class Deposito implements Transaccion{
    double monto;
    boolean realizado;

    public Deposito(double monto) {
        this.monto = monto;
        this.realizado = false;
    }

    public void realizarDeposito(Cliente cliente) {
        cliente.setDineroEnCuenta(cliente.getDineroEnCuenta() + monto);
        System.out.println("Realizándose depósito de " + monto + " a la cuenta de " + cliente.getNombre() + " " + cliente.getApellido());
        realizado = true;
    }

    @Override
    public boolean transaccionOk() {
        return realizado;
    }

    @Override
    public boolean transaccionNoOk() {
        return !realizado;
    }

}
