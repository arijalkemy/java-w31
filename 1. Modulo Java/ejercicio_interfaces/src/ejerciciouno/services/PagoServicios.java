package ejerciciouno.services;

import ejerciciouno.interfaces.IPagoServicios;

public class PagoServicios implements IPagoServicios {
    @Override
    public void pagarServicios() {
        System.out.println("Pagando Servicios");
    }

    @Override
    public void transaccionOk() {
        System.out.println("PagoServicios Transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("PagoServicios Transaccion No Ok");
    }
}
