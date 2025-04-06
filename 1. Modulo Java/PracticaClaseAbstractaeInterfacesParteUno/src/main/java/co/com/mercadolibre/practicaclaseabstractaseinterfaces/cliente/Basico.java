package co.com.mercadolibre.practicaclaseabstractaseinterfaces.cliente;

import co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia.ConsultaDeSaldo;
import co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia.PagoDeServicios;
import co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia.RetiroEfectivo;
import co.com.mercadolibre.practicaclaseabstractaseinterfaces.transferencia.Transaccion;

public class Basico extends Cliente {

    public Basico(String nombre, Double saldo, String dni) {
        super(nombre, saldo, dni);
    }

    @Override
    public String ejecutarTransaccion(Cliente cliente, Transaccion transaccion) {

        return switch (transaccion){
            case ConsultaDeSaldo consulta -> transaccion.transaccionOk(cliente, consulta);
            case PagoDeServicios pagos -> transaccion.transaccionOk(cliente, pagos);
            case RetiroEfectivo retiro -> transaccion.transaccionOk(cliente, retiro);
            default -> transaccion.transaccionNoOk(cliente, transaccion);
        };
    }
}
