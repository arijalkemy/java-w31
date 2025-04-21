package com.company;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;
    private double descuento;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.total = 0;
        this.descuento = 0;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void agregarReserva(String tipo, double precio){
        Reserva r = new Reserva(tipo, precio);
        reservas.add(r);
        total += precio;
    }

    public void aplicarDescuento(){
        if(cliente.cantidadDeLocalizadores()>= 2){
            descuento = total * 0.05;
        }else if(tienePaqueteCompleto()){
            descuento = total* 0.10;
        }else if(contarTipo("hotel")==2 || contarTipo("boletos")== 2){
            descuento = total * 0.05;
        }
        total -= descuento;
    }

    public boolean tienePaqueteCompleto() {
       return contarTipo("hotel") > 0 &&
               contarTipo("comida") > 0 &&
               contarTipo("boletos") > 0 &&
               contarTipo("transporte") > 0;
    }

    private long contarTipo(String tipo){
        return reservas.stream().filter(r-> r.getTipo().equalsIgnoreCase(tipo)).count();
    }

    public void imprimirLocalizador() {
        for (Reserva r : reservas) {
            double porcentaje = r.getPrecio() / (total + descuento);
            double desc = porcentaje * descuento;
            System.out.printf("Localizador: %s - Tipo: %s - Total: %.2f - Descuento: %.2f%n",
                    cliente.getNombre(), r.getTipo(), r.getPrecio(), desc);
        }
    }

}
