package org.example.bancoAbstracto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.bancoAbstracto.TIPO_TRANSACCION;

public class TransaccionFactory {
    private final Map<TIPO_CLIENTE, List<TIPO_TRANSACCION>> transaccionesPermitidas;

    public TransaccionFactory() {
        transaccionesPermitidas = new HashMap<>();
        transaccionesPermitidas.put(TIPO_CLIENTE.EJECUTIVO, Arrays.asList(TIPO_TRANSACCION.DEPOSITO, TIPO_TRANSACCION.TRANSFERENCIA));
        transaccionesPermitidas.put(TIPO_CLIENTE.BASICO, Arrays.asList(TIPO_TRANSACCION.CONSULTA, TIPO_TRANSACCION.PAGO, TIPO_TRANSACCION.RETIRO));
        transaccionesPermitidas.put(TIPO_CLIENTE.COBRADOR, Arrays.asList(TIPO_TRANSACCION.CONSULTA, TIPO_TRANSACCION.RETIRO));
    }

    public List<TIPO_TRANSACCION> getTransaccionesPermitidas(TIPO_CLIENTE tipo) {
        return this.transaccionesPermitidas.get(tipo);
    }

    public Transaccion createTransaccion(TIPO_TRANSACCION tipo) {
        return switch (tipo) {
            case DEPOSITO -> new Deposito();
            case CONSULTA -> new ConsultaSaldo();
            case PAGO -> new PagoDeServicios();
            case RETIRO -> new RetiroEfectivo();
            case TRANSFERENCIA -> new Transferencia();
        };
    }

    public boolean isValidTransaccionForClient(TIPO_CLIENTE tipo, TIPO_TRANSACCION transaccion) {
        if (transaccionesPermitidas.containsKey(tipo)) {
            return transaccionesPermitidas.get(tipo).contains(transaccion);
        }
        return false;
    }
}
