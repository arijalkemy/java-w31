package exerciseInterface.punto1.clases;

import exerciseInterface.punto1.interfaces.Deposito;
import exerciseInterface.punto1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public Boolean TransaccionOk() {
       System.out.println(" transaccion exitosa");
       return true;
    }

    @Override
    public Boolean TransaccionNoOk() {
       System.out.println(" Transaccion fallida");
       return false;
    }

    @Override
    public boolean Transferir() {
        this.TransaccionNoOk();
        return false;
    }

    @Override
    public String Depositar() {
        this.TransaccionOk();
        return " Depositando";
    }

}

