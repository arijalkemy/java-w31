package org.meli.agenciadeturismo.domain;

public class Reserva {

    private boolean hotel, comida, boletosDeViaje, transporte;

    public Reserva() {
    }

    public Reserva(boolean hotel, boolean comida, boolean boletosDeViaje, boolean transporte) {
        this.hotel = hotel;
        this.comida = comida;
        this.boletosDeViaje = boletosDeViaje;
        this.transporte = transporte;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isBoletosDeViaje() {
        return boletosDeViaje;
    }

    public void setBoletosDeViaje(boolean boletosDeViaje) {
        this.boletosDeViaje = boletosDeViaje;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public boolean isCompleto() {
        return (isHotel() && isComida() && isBoletosDeViaje() && isTransporte()) ? true : false;
    }


    @Override
    public String toString() {
        return "Reserva{" +
                "hotel=" + hotel +
                ", comida=" + comida +
                ", boletosDeViaje=" + boletosDeViaje +
                ", transporte=" + transporte +
                '}';
    }
}
