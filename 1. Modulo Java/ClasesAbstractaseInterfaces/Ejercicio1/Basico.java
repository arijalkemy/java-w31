package ClasesAbstractaseInterfaces.Ejercicio1;

public class Basico extends Cliente {
    public Basico(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public double consultaSaldo() {
        ConsultaSaldo consulta = new ConsultaSaldo(this);
        return consulta.consultarSaldo();
    }

    public boolean pagarServicios(double monto) {
        PagoServicios pago = new PagoServicios(monto);
        pago.realizarPago(this);
        return pago.transaccionOk();
    }

    public boolean retirarEfectivo(double monto) {
        RetiroEfectivo retiro = new RetiroEfectivo(monto);
        retiro.realizarRetiroEfectivo(this);
        return retiro.transaccionOk();
    }
}
