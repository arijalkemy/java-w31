package ClasesAbstractaseInterfaces.P1.Ejercicio1;

public class PagoServicios implements Transaccion{
    private double monto;
    private boolean realizado;

    public PagoServicios(double monto) {
        this.monto = monto;
        this.realizado = false;
    }

    public void realizarPago(Cliente cliente) {
        if (cliente.getDineroEnCuenta() >= monto) {
            cliente.setDineroEnCuenta(cliente.getDineroEnCuenta() - monto);
            System.out.println("Pago de servicios realizado por " + cliente.getNombre() + " " + cliente.getApellido() + " por un monto de " + monto);
            realizado = true;
        } else {
            System.out.println("Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " no tiene suficiente dinero en la cuenta para realizar el pago de los servicios.");
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
