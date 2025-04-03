package ClasesAbstractaseInterfaces.P1.Ejercicio1;

public class Cobrador extends Cliente {
    public Cobrador(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public boolean realizarRetiroEfectivo(double monto) {
        RetiroEfectivo retiro = new RetiroEfectivo(monto);
        retiro.realizarRetiroEfectivo(this);
        return retiro.transaccionOk();
    }

    public double consultarSaldo() {
        ConsultaSaldo consulta = new ConsultaSaldo(this);
        return consulta.consultarSaldo();
    }
}