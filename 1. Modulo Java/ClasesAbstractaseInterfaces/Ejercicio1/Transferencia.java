package ClasesAbstractaseInterfaces.P1.Ejercicio1;

public class Transferencia implements Transaccion {
    double monto;
    boolean realizado;
    Cliente cliente;

    public Transferencia(double monto, Cliente cliente) {
        this.monto = monto;
        this.cliente = cliente;
        this.realizado = false;
    }

    public void realizarTransferencia(Cliente emisor, Cliente receptor) {
        if (emisor.getDineroEnCuenta() >= monto) {
            emisor.setDineroEnCuenta(emisor.getDineroEnCuenta() - monto);
            receptor.setDineroEnCuenta(receptor.getDineroEnCuenta() + monto);
            System.out.println("Realizándose transferencia de " + monto + " de " + emisor.getNombre() + " " + emisor.getApellido() + " a " + receptor.getNombre() + " " + receptor.getApellido());
            realizado = true;
        } else {
            System.out.println("El cliente " + emisor.getNombre() + " " + emisor.getApellido() + " tiene fondos insuficientes para realizar la transferencia.");
            realizado = false;
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

