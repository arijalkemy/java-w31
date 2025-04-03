package servicios;

import enumeradores.Descuentos;
import enumeradores.TipoReserva;
import modelos.Localizador;
import modelos.Reserva;
import repository.LocalizadorRepository;

import java.util.*;
import java.util.stream.Collectors;

public class LocalizadorService {
    private final LocalizadorRepository repository;
    private Localizador localizador;

    public LocalizadorService(LocalizadorRepository repository, Localizador localizador) {
        this.repository = repository;
        this.localizador = localizador;
        guardarLocalizador();
    }

    public Localizador getLocalizador() {
        return localizador;
    }

    public void setLocalizador(Localizador localizador) {
        this.localizador = localizador;
        guardarLocalizador();
    }

    private void guardarLocalizador() {
        repository.agregarLocalizador(localizador);
    }

    public Reserva agregarReserva(Reserva reserva) {
        localizador.getReservas().add(reserva);
        return reserva;
    }

    public double obtenerTotalReservas() {
        double total = localizador.getTotalReservasSinDescuento();
        long cantidadLocalizadores = repository.obtenerCantidadLocalizadores(localizador.getCliente().getDni());
        if(cantidadLocalizadores >= Descuentos.LOCALIZADORES_PREVIOS.getCantidadValidaParaDescuento()){
            total = total - (total * ((double) Descuentos.LOCALIZADORES_PREVIOS.getPorcentaje() / 100));
        }

        if(tienePaqueteCompleto()){
            total = total - (total * ((double) Descuentos.PAQUETE_COMPLETO.getPorcentaje() / 100));
        }

        double descuentoReservas = 0;
        for(Map.Entry<Descuentos, Set<TipoReserva>> mapEntry : localizador.getDescuentosTipoReservas().entrySet()){
            List<Reserva> reservasAptas = localizador.getReservas().stream()
                    .filter(reserva -> mapEntry.getValue().contains(reserva.getTipoReserva()))
                    .collect(Collectors.groupingBy(Reserva::getTipoReserva))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue().size() >= mapEntry.getKey().getCantidadValidaParaDescuento())
                    .flatMap(entry -> entry.getValue().stream())
                    .toList();
            for(Reserva reserva : reservasAptas){
                descuentoReservas += reserva.getValorReserva() * ((double) mapEntry.getKey().getPorcentaje() / 100);
            }
        }
        total -= descuentoReservas;

        localizador.setTotalReservas(total);
        return total;
    }

    private boolean tienePaqueteCompleto() {
        Set<TipoReserva> tiposPresentes = localizador.getReservas().stream()
                .map(Reserva::getTipoReserva)
                .collect(Collectors.toSet());
        return tiposPresentes.containsAll(Set.of(TipoReserva.values()));
    }

    public String detalles(){
        StringBuilder builder = new StringBuilder();
        builder.append("----------------------------------------------").append(System.lineSeparator());
        builder.append(localizador.getCliente().getName()).append(": ").append(localizador.getCliente().getDni()).append("\n");
        for(Reserva reserva : localizador.getReservas()){
            builder.append(reserva.getTipoReserva()).append("= $").append(reserva.getValorReserva()).append("\n");
        }
        builder.append("Total reserva: $").append(localizador.getTotalReservasSinDescuento()).append("\n");
        builder.append("Total reserva final: $").append(obtenerTotalReservas()).append("\n");
        return builder.toString();
    }


}
