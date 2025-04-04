package dev.michellarias.entity;

import dev.michellarias.enums.TipoProducto;

import java.util.*;
import java.util.stream.Collectors;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;
    private Double total;


    public Localizador() {
        this.reservas = new ArrayList<>();
    }

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public void calcularDescuento(boolean descuentoAdicional) {
        int limiteDescuento = 2;
        boolean paqueteCompleto = validarPaqueteCompleto();

        if (descuentoAdicional){
            Double nuevoTotal = getTotal();
            Double totalDescuento = (5 * nuevoTotal) / 100;
            nuevoTotal -= totalDescuento;
            setTotal(nuevoTotal);
        }

        if (paqueteCompleto) {
            Double totalDescuento = (10 * getTotal()) / 100;
            setTotal(getTotal() - totalDescuento);
        }

        reservas.forEach(r -> {
            if ((r.getTipoProducto().equals(TipoProducto.HOTEL) ||
                    r.getTipoProducto().equals(TipoProducto.BOLETO)) &&
                    r.getCantidad() >= limiteDescuento) {

                // Aplicamos el descuento en las que cumplen requisitos.
                r.aplicarDescuentoTres();
            }
        });
    }

    public boolean validarPaqueteCompleto(){
        EnumSet<TipoProducto> tiposRequeridos = EnumSet.of(
                TipoProducto.COMIDA,
                TipoProducto.HOTEL,
                TipoProducto.TRANSPORTE,
                TipoProducto.BOLETO
        );

        Set<TipoProducto> tiposPresentes = reservas.stream()
                .map(Reserva::getTipoProducto)
                .collect(Collectors.toSet());

        return tiposPresentes.containsAll(tiposRequeridos);
    }


    public Localizador addReserva(Reserva reserva) {
        this.reservas.add(reserva);
        return this;
    }

    public void removeReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }

    private Double calcularTotalLocalizador(){
        return reservas
                .stream()
                .mapToDouble(Reserva::getTotal)
                .sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Double getTotal() {
        if (Objects.isNull(total)) {
            return calcularTotalLocalizador();
        }else {
            return total;
        }
    }



    public void setTotal(Double total) {
        this.total = total;
    }

}