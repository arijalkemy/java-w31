package exerciseIntegrador1.clases;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Integer idLocalizador;
    private Double precioTotalReservas;
    List<Reserva> listReserva = new ArrayList<>();
    Cliente cliente;

    public Localizador(Integer idLocalizador, List<Reserva> listReserva, Cliente cliente) {
        this.idLocalizador = idLocalizador;
        this.listReserva = listReserva;
        this.cliente = cliente;
        calcularPrecioTotalReservas(0D);
    }

    public Integer getIdLocalizador() {
        return idLocalizador;
    }

    public void setIdLocalizador(Integer idLocalizador) {
        this.idLocalizador = idLocalizador;
    }

    public List<Reserva> getListReserva() {
        return listReserva;
    }

    public void setListReserva(List<Reserva> listReserva) {
        this.listReserva = listReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void calcularPrecioTotalReservas(Double descuento ) {
        
        Double precioTotalReservas = listReserva.stream().map(Reserva :: getPrecioReserva).reduce(0.0D, Double :: sum);
        this.precioTotalReservas = precioTotalReservas - ((precioTotalReservas*descuento)/100);
    }

    public Double obtenerPrecioTotalReserva() {
        return this.precioTotalReservas;
    }

    
    
}
