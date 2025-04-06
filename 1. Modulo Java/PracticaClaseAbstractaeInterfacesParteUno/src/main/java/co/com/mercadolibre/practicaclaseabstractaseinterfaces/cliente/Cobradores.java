package co.com.mercadolibre.practicaclaseabstractaseinterfaces.cliente;

import co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia.ConsultaDeSaldo;
import co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia.RetiroEfectivo;
import co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia.Transaccion;

public class Cobradores extends Cliente {

    public Cobradores(String nombre, Double saldo, String dni) {
        super(nombre, saldo, dni);
    }

    @Override
    public String ejecutarTransaccion(Cliente cliente, Transaccion transaccion) {
        // TODO Auto-generated method stub
        return switch (transaccion){
            case RetiroEfectivo retiro -> transaccion.transaccionOk(cliente, retiro);
            case ConsultaDeSaldo consulta -> transaccion.transaccionOk(cliente, consulta);
            default -> transaccion.transaccionNoOk(cliente, transaccion);
        };
    }

    

}
