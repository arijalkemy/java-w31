package Model.Ejercicio1.Cliente;

import Model.Ejercicio1.Transacciones.ConsultaDeSaldo;
import Model.Ejercicio1.Transacciones.RetiroDeEfectivo;

public class Cobrador extends Cliente implements RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Soy un Cliente Cobrador que implementa el metodo consultarSaldo");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Soy un Cliente Cobrador que implementa el metodo retirarEfectivo");
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
