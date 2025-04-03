package com.mercadolimbre.modulojava.agenciadeturismo;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;
    private RepositorioCliente repositorioCliente;

    public Localizador(Cliente cliente, List<Reserva> reservas, RepositorioCliente repositorioCliente) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.repositorioCliente = repositorioCliente;
        this.repositorioCliente.agregarLocalizador(this);
        this.total = this.calcularTotalConDescuentos();

    }

    public Cliente getCliente() {
        return cliente;
    }

    public double calcularTotal() {
        double suma = (double)0.0F;

        for(Reserva reserva : this.reservas) {
            suma += reserva.getPrecio();
        }

        return suma;
    }

    public Map<String, Integer> calcularCantidadReservas(List<Reserva> reservas) {
        Map<String, Integer> contadores = new HashMap();
        int contBoleto = 0;
        int contComida = 0;
        int contHotel = 0;
        int contTransporte = 0;

        for(Reserva reserva : reservas) {
            switch (reserva.getTipo()) {
                case "boleto":
                    ++contBoleto;
                case "comida":
                    ++contBoleto;
                case "hotel":
                    ++contBoleto;
                case "transporte":
                    ++contBoleto;
            }
        }

        contadores.put("boleto", contBoleto);
        contadores.put("comida", contComida);
        contadores.put("hotel", contHotel);
        contadores.put("transporte", contTransporte);
        return contadores;
    }

    public double calcularTotalConDescuentos() {
        this.calcularDescuentoTipoReserva();
        double suma = this.calcularTotal();
        double descuento = (double)0.0F;

        if(this.verificarReservas()){
            descuento=descuento+10.00;
        }if(repositorioCliente.obtenerLocalizadores(this.cliente).size()>=3){
            descuento=descuento+5.00;
        }
     
        return suma-(suma*(descuento/100.0));
    }

    public void calcularDescuentoTipoReserva() {
        Map<String, Integer> contadores = this.calcularCantidadReservas(this.reservas);
        if ((Integer)contadores.get("hotel") >= 2) {
            this.reservas.stream().filter((x) -> x.getTipo() == "hotel").forEach((x) -> x.setPrecio(x.getPrecio() - x.getPrecio() * 0.05));
        }

        if ((Integer)contadores.get("boleto") >= 2) {
            this.reservas.stream().filter((x) -> x.getTipo() == "boleto").forEach((x) -> x.setPrecio(x.getPrecio() - x.getPrecio() * 0.05));
        }

    }
    public Boolean verificarReservas() {
        boolean hayComida = false;
        boolean hayHotel = false;
        boolean hayTransporte = false;
        boolean hayBoleto = false;
        for(Reserva reserva : this.reservas) {
            if(reserva instanceof ReservaComida) {
                hayComida = true;
            } else if (reserva instanceof ReservaHotel) {
                hayHotel = true;

            }else if (reserva instanceof ReservaTransporte) {
                hayTransporte = true;
            }else if (reserva instanceof ReservaBoleto) {
                hayBoleto = true;

            }
        }
        return hayBoleto && hayHotel && hayTransporte && hayComida;

    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                '}';
    }
}

