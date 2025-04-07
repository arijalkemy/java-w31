package bootcamp.abstracciones_interfaces.ej1;

import bootcamp.abstracciones_interfaces.ej1.interfaces.ConsultarSaldo;
import bootcamp.abstracciones_interfaces.ej1.interfaces.PagarServicio;
import bootcamp.abstracciones_interfaces.ej1.interfaces.RetiroEfectivo;
import bootcamp.abstracciones_interfaces.ej1.interfaces.Transaccion;

public class Basic implements ConsultarSaldo, PagarServicio, RetiroEfectivo, Transaccion {

    @Override
    public void consultarSaldo() {
        System.out.println("Basic consultan saldo");
    }

    @Override
    public void pagarServicio(String servicio) {
        System.out.println("Basic paga servicio: " + servicio);
    }

    @Override
    public void hacerRetiro(double monto) {
        System.out.println("Basic retiro: $" + monto);
    }

}
