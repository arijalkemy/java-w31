package exerciseIntegrador1.repositorio;

import java.util.ArrayList;
import java.util.List;
import exerciseIntegrador1.clases.Localizador;
import exerciseIntegrador1.clases.Reserva;

public class RepoCliente {
    List<Localizador> listLocalizadors = new ArrayList<>();

    public Double añadirLocalizador(Localizador localizador) {
        Double dcto = calcularDescuento(localizador);
        localizador.calcularPrecioTotalReservas(dcto);
        listLocalizadors.add(localizador);
        return localizador.obtenerPrecioTotalReserva();
    }

    private Double calcularDescuento(Localizador localizador) {
        // descuento por paquete completo
        boolean hasFood = localizador.getListReserva().stream()
                .anyMatch(reserva -> reserva.getTipoReserva().equals("Comida"));
        boolean hasHotel = localizador.getListReserva().stream()
                .anyMatch(reserva -> reserva.getTipoReserva().equals("Hotel"));
        boolean hasTransporte = localizador.getListReserva().stream()
                .anyMatch(reserva -> reserva.getTipoReserva().equals("Transporte"));
        boolean hasBoleto = localizador.getListReserva().stream()
                .anyMatch(reserva -> reserva.getTipoReserva().equals("Boleto Viaje"));

        boolean aplica10Dcto = hasBoleto && hasHotel && hasFood && hasTransporte;
        if (aplica10Dcto) {
            return 10.0D;
        }

        // descuento si el cliente tiene un segundo viaje
        Long cantidadLocalizadores = listLocalizadors.stream().filter((Localizador l) -> l.getCliente().getDni()
                .equals(localizador.getCliente().getDni())).count();
        Long cantidadReservasHotel = localizador.getListReserva().stream()
                .filter((Reserva reserva) -> reserva.getTipoReserva().equals("Hotel")).count();
        Long cantidadReservasBoletoViaje = localizador.getListReserva().stream()
                .filter((Reserva reserva) -> reserva.getTipoReserva().equals("Boleto Viaje")).count();

        boolean aplica5Dcto = cantidadLocalizadores > 0 || cantidadReservasHotel >= 2
                || cantidadReservasBoletoViaje >= 2;
        if (aplica5Dcto) {
            return 5.0D;
        }

        return 0.0D;
    }

}
