package exerciseInterface.punto1.clases;

import exerciseInterface.punto1.interfaces.ConsultaSaldo;
import exerciseInterface.punto1.interfaces.PagoServicios;
import exerciseInterface.punto1.interfaces.RetiroEfectivo;

public class Basico implements ConsultaSaldo,PagoServicios,RetiroEfectivo {

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
    public boolean Retirar() {
        this.TransaccionNoOk();
        return false;
       
    }

    @Override
    public String consultaSaldo() {
        this.TransaccionOk();
        return " Consultando";
    }

    @Override
    public String pagoService() {
      this.TransaccionOk();
      return " Realizando pago";
    }


}
