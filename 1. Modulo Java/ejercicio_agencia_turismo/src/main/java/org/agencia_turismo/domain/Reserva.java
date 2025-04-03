package org.agencia_turismo.domain;

public class Reserva {
    private Boolean hotel, transporte, comida, boletosDeViaje;

    public Reserva() {
    }

    public Reserva(Boolean hotel, Boolean comida, Boolean boletosDeViaje, Boolean transporte) {
        this.hotel = hotel;
        this.comida = comida;
        this.boletosDeViaje = boletosDeViaje;
        this.transporte = transporte;
    }

    public Boolean getHotel() {
        return hotel;
    }

    public void setHotel(Boolean hotel) {
        this.hotel = hotel;
    }

    public Boolean getTransporte() {
        return transporte;
    }

    public void setTransporte(Boolean transporte) {
        this.transporte = transporte;
    }

    public Boolean getComida() {
        return comida;
    }

    public void setComida(Boolean comida) {
        this.comida = comida;
    }

    public Boolean getBoletosDeViaje() {
        return boletosDeViaje;
    }

    public void setBoletosDeViaje(Boolean boletosDeViaje) {
        this.boletosDeViaje = boletosDeViaje;
    }

    public boolean isCompleto() {
        return this.hotel && this.comida && this.boletosDeViaje && this.transporte;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "hotel=" + hotel +
                ", transporte=" + transporte +
                ", comida=" + comida +
                ", boletosDeViaje=" + boletosDeViaje +
                '}';
    }
}
