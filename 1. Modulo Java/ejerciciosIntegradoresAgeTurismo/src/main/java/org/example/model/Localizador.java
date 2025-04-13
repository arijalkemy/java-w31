package org.example.model;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private Double total;
    private List<Reserva> reservaList;

    public Localizador(Cliente cliente, List<Reserva> reservaList) {
        this.cliente = cliente;

        this.reservaList = reservaList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public Boolean clienteAdquirioPackCompleto(){
        int cantidadHotelReservado = this.reservaList.stream().
                filter(reserva -> reserva.getClass().equals(Hotel.class)).toList().size();

        int cantidadComidaReservada = this.reservaList.stream().
                filter(reserva -> reserva.getClass().equals(Comida.class)).toList().size();

        int cantidadTiqueteReservado = this.reservaList.stream().
                filter(reserva -> reserva.getClass().equals(Tiquete.class)).toList().size();

        int cantidadTransporteReservado = this.reservaList.stream().
                filter(reserva -> reserva.getClass().equals(Transporte.class)).toList().size();

        return cantidadHotelReservado > 1 && cantidadComidaReservada > 1 && cantidadTiqueteReservado > 1 &&
                cantidadTransporteReservado > 1;
    }

    public Boolean clienteAdquirioDosReservasHotel(){
        List<Reserva> reservaList1 = this.reservaList.stream().
                filter(reserva -> reserva.getClass().equals(Hotel.class)).toList();
        return reservaList1.size()>=2;
    }

    public Boolean clienteAdquirioDosTiquetes(){
        List<Reserva> reservaList1 = this.reservaList.stream().
                filter(reserva -> reserva.getClass().equals(Tiquete.class)).toList();
        return reservaList1.size()>=2;
    }

    public void calcularTotal(){
        this.total= this.reservaList.stream().mapToDouble(Reserva::getPrecio).sum();

        if(clienteAdquirioPackCompleto()){
            this.total=this.total - (this.total*0.1);
        }else if(clienteAdquirioDosReservasHotel() || clienteAdquirioDosTiquetes()){
            this.total=this.total - (this.total*0.05);
        }
    }
}
