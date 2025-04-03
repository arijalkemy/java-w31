package org.meli.agenciadeturismo.repository;

import org.meli.agenciadeturismo.domain.Cliente;
import org.meli.agenciadeturismo.domain.Localizador;
import org.meli.agenciadeturismo.domain.Reserva;

import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository<Cliente> {

    @Override
    public double aplicarDescuento(Cliente cliente) {
        double descuentoTotal = 0;

        if (cliente.getLocalizadorList().size() >= 2){
            return descuentoTotal += 0.05;
        }
        long contador =  cliente.getLocalizadorList().stream()
                .flatMap(localizador -> localizador.getReservaList().stream())
                .filter(Reserva::isCompleto)
                .count();
        if (contador >= 0){

        }
    }
}
