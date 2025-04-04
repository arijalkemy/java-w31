package dev.michellarias.entity;

import dev.michellarias.enums.TipoProducto;

public class Reserva {

    private TipoProducto tipoProducto;
    private Integer cantidad;
    private Double valor;
    private Double total;

    public Reserva(TipoProducto tipoProducto, Integer cantidad, Double valor) {
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.total = valor * cantidad;
    }

    public void aplicarDescuentoTres() {
        int descuento = 5; // %
        Double totalDescuento = (descuento * total)  / 100;
        this.total -= totalDescuento;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipoProducto=" + tipoProducto +
                ", cantidad=" + cantidad +
                ", valor=" + valor +
                ", total=" + total +
                '}';
    }
}
