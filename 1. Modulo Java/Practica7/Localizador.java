package Practica7;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    Cliente cliente;
    List<Reserva> reservas;
    double total;
    double totalConDescuento;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.total = 0;
        this.reservas = new ArrayList<>();
        this.totalConDescuento = 0;
    }

    public void agregarReserva(Reserva p){
        this.reservas.add(p);
        calcularTotal(p);
        calcularDescuento(p);
    }

    public void calcularTotal(Reserva p){
        this.total += p.getValor();
    }

    public void calcularDescuento(Reserva p){ //TODO


    }

    public double getTotalConDescuento() {
        return totalConDescuento;
    }

    public void setTotalConDescuento(double totalConDescuento) {
        this.totalConDescuento = totalConDescuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", productos=" + reservas +
                ", total=" + total +
                '}';
    }
}

