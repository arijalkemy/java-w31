package bootcamp.abstracciones_interfaces.ej1;

import bootcamp.abstracciones_interfaces.ej1.interfaces.ConsultarSaldo;
import bootcamp.abstracciones_interfaces.ej1.interfaces.RetiroEfectivo;
import bootcamp.abstracciones_interfaces.ej1.interfaces.Transaccion;

public class Cobrador implements RetiroEfectivo, ConsultarSaldo, Transaccion {
    @Override
    public void consultarSaldo() {
        System.out.println("Cobrador consulta Saldo");
    }

    @Override
    public void hacerRetiro(double monto) {
        System.out.println("Cobrador hace retiro de: $" + monto);
    }
}
