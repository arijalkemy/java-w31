package ejercicio_turismo.Model;

import java.util.ArrayList;

public class Localizador {
    private Cliente cliente;
    private Double total;
    private ArrayList<Reserva> reservas;
    private Double descuento;
    private Integer id;

    public Localizador(Cliente cliente, ArrayList<Reserva> reservas, Integer id) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = reservas;
        aplicarDescuento();
    }

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getTotal() {
        return total;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void aplicarDescuento() {
        descuento = 0.0;
        if (cliente.getTotalLocalizadores() >= 2) {
            descuento += 0.05;
        }
        if (esPaqueteCompleto()) {
            descuento += 0.10;
        }
        if (dosHotel()) {
            descontarHotel();
        }
        if (dosTransporte()) {
            descontarTransporte();
        }
        calcularTotal();
    }

    private Boolean esPaqueteCompleto() {
        Boolean hotel = false;
        Boolean comida = false;
        Boolean boleta = false;
        Boolean transporte = false;

        for (Reserva reserva : reservas) {
            if (reserva.getTipoReserva() == TipoReserva.HOTEL) {
                hotel = true;
            } else if (reserva.getTipoReserva() == TipoReserva.COMIDA) {
                comida = true;
            } else if (reserva.getTipoReserva() == TipoReserva.BOLETA) {
                boleta = true;
            } else if (reserva.getTipoReserva() == TipoReserva.TRANSPORTE) {
                transporte = true;
            }
            if (hotel && comida && boleta && transporte) {
                return true;
            }
        }

        return false;
    }

    private Boolean dosHotel() {
        Integer contador = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getTipoReserva() == TipoReserva.HOTEL) {
                contador++;
            }
            if (contador >= 2) {
                return true;
            }
        }
        return false;
    }

    private void descontarHotel() {
        for (Reserva reserva : reservas) {
            if (reserva.getTipoReserva() == TipoReserva.HOTEL) {
                reserva.setPrecio(reserva.getPrecio() * 0.95);
            }
        }
    }

    private Boolean dosTransporte() {
        Integer contador = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getTipoReserva() == TipoReserva.TRANSPORTE) {
                contador++;
            }
            if (contador >= 2) {
                return true;
            }
        }
        return false;
    }

    private void descontarTransporte() {
        for (Reserva reserva : reservas) {
            if (reserva.getTipoReserva() == TipoReserva.TRANSPORTE) {
                reserva.setPrecio(reserva.getPrecio() * 0.95);
            }
        }
    }

    private void calcularTotal() {
        total = 0.0;
        for (Reserva reserva : reservas) {
            total += reserva.getPrecio();
        }
        total -= total * descuento;
    }

    @Override
    public String toString() {
        return "Localizador [cliente=" + cliente + ", total=" + total + ", reservas=" + reservas + ", descuento="
                + descuento + "]";
    }

}
