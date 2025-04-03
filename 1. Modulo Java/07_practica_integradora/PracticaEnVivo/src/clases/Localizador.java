package clases;

import interfaces.Reserva;

import java.util.List;

public class Localizador {
    Client cliente;
    List<Reserva> reservas;
    Double total;

    private Boolean descuentoPaqueteCompleto(){
        boolean hayReservaHotel = reservas.stream()
                .anyMatch(reserva -> reserva.getClass() == ReservaHotel.class);
        boolean hayReservaBoleto = reservas.stream()
                .anyMatch(reserva -> reserva.getClass() == ReservaBoleto.class);
        boolean hayReservaComida = reservas.stream()
                .anyMatch(reserva -> reserva.getClass() == ReservaComida.class);
        boolean hayReservaTransporte = reservas.stream()
                .anyMatch(reserva -> reserva.getClass() == ReservaTransporte.class);

        return hayReservaBoleto && hayReservaComida && hayReservaHotel && hayReservaTransporte;
    }

    private Boolean descuentoDosReservasHotel(){
        return reservas.stream().filter(res -> res.getClass().equals(ReservaHotel.class)).count() >= 2;
    }
    private Boolean descuentoDosReservasBoleto(){
        return reservas.stream().filter(res -> res.getClass().equals(ReservaBoleto.class)).count() >= 2;
    }
    private void aplicarDescuentoReserva(){
        if(descuentoDosReservasBoleto()){
            reservas.stream().filter(res -> res.getClass().equals(ReservaHotel.class)).forEach( res ->
                    res.setPrecio( res.getPrecio() - (res.getPrecio() * 0.05)));
        } else if (descuentoDosReservasHotel()) {
            reservas.stream().filter(res -> res.getClass().equals(ReservaBoleto.class)).forEach( res ->
                    res.setPrecio( res.getPrecio() - (res.getPrecio() * 0.05)));
        }
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Double getTotal() {
        return reservas.stream().mapToDouble( res -> res.getPrecio()).sum();
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public Localizador(Client cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public void imprimir(){
        System.out.println(this.getCliente().toString());
        reservas.forEach(res -> {
            System.out.println(res.toString());
        });
    }

    public void calcularDescuento(){
        aplicarDescuentoReserva();
        total = getTotal();
        if(cliente.getTieneDescuento()){
            total = total - (total * 0.05);
        } else if (descuentoPaqueteCompleto()) {
            total = total - (total * 0.10);
        }
    }
}
