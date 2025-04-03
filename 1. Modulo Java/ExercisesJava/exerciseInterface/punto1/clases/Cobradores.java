package exerciseInterface.punto1.clases;

import exerciseInterface.punto1.interfaces.ConsultaSaldo;
import exerciseInterface.punto1.interfaces.RetiroEfectivo;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo {

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
    public String consultaSaldo() {
       this.TransaccionOk();
       return " Consultando saldo";
    }

    @Override
    public boolean Retirar() {
        this.TransaccionNoOk();
        return false;
    }

    

}
