package ClasesAbstractaseInterfaces.Ejercicio1;

public class RetiroEfectivo implements Transaccion {
    private boolean realizado;
    private double monto;

    public RetiroEfectivo(double monto) {
        this.monto = monto;
        this.realizado = false;
    }

    public void realizarRetiroEfectivo(Cliente cliente) {
        if (cliente.getDineroEnCuenta() >= this.monto) {
            cliente.setDineroEnCuenta(cliente.getDineroEnCuenta() - monto);
            this.realizado = true;
        } else {
            System.out.println("No hay suficiente dinero en la cuenta.");
            this.realizado = false;
        }
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
