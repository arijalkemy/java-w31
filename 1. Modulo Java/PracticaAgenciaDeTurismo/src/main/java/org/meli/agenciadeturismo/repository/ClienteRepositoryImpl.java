package org.meli.agenciadeturismo.repository;

import org.meli.agenciadeturismo.domain.Cliente;
import org.meli.agenciadeturismo.domain.Reserva;


public class ClienteRepositoryImpl implements ClienteRepository<Cliente> {

    @Override
    public double aplicarDescuento(Cliente cliente) {
        double descuentoTotal = 0;
        int sizeOfTheLocalizadores = cliente.getLocalizadorList().size();
        if (sizeOfTheLocalizadores >= 2){
            descuentoTotal += 0.05;
            long contador =  cliente.getLocalizadorList().stream()
                    .flatMap(localizador -> localizador.getReservaList().stream())
                    .filter(Reserva::isCompleto)
                    .count();
                    if (contador > 0){
                        descuentoTotal += 0.10;
                    }
                    long contadorDos = cliente.getLocalizadorList().stream()
                    .flatMap(localizador -> localizador.getReservaList().stream())
                    .filter(r -> r.isBoletosDeViaje() || r.isHotel())
                    .count();
                    if (contadorDos == 2) {
                        descuentoTotal += 0.05;
                    }
                    return descuentoTotal;
        }else if (sizeOfTheLocalizadores <= 1 && sizeOfTheLocalizadores >= 0) {
                long contador =  cliente.getLocalizadorList().stream()
                    .flatMap(localizador -> localizador.getReservaList().stream())
                    .filter(Reserva::isCompleto)
                    .count();
                    if (contador > 0){
                        descuentoTotal += 0.10;
                    }
                long contadorDos = cliente.getLocalizadorList().stream()
                    .flatMap(localizador -> localizador.getReservaList().stream())
                    .filter(r -> r.isBoletosDeViaje() || r.isHotel())
                    .count();
                    if (contadorDos == 2) {
                        descuentoTotal += 0.05;
                    }
                    return descuentoTotal;
        } 
        return descuentoTotal;
    }
}
