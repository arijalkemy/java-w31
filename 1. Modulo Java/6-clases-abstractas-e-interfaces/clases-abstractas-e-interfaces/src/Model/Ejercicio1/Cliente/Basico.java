package Model.Ejercicio1.Cliente;

import Model.Ejercicio1.Transacciones.ConsultaDeSaldo;
import Model.Ejercicio1.Transacciones.PagoDeServicios;
import Model.Ejercicio1.Transacciones.RetiroDeEfectivo;

public class Basico extends Cliente implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("Soy un Cliente Basico que implementa el metodo consultarSaldo");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Soy un Cliente Basico que implementa el metodo pagarServicios");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Soy un Cliente Basico que implementa el metodo retirarEfectivo");
    }

    @Override
    public Boolean transaccionOk() {
        return null;
    }

    @Override
    public Boolean transaccionNoOk() {
        return null;
    }
}
