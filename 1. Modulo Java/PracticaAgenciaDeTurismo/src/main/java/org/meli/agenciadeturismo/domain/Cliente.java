package org.meli.agenciadeturismo.domain;

import java.util.ArrayList;
import java.util.List;


public class Cliente {

    private String nombre, apellido;
    private long id;
    private List<Localizador> localizadorList;
    private double descuentoTotalAplicado;

    public Cliente() {
        localizadorList = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido, long id, List<Localizador> localizadorList,
                   double descuentoTotalAplicado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.localizadorList = localizadorList;
        this.descuentoTotalAplicado = descuentoTotalAplicado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Localizador> getLocalizadorList() {
        return localizadorList;
    }

    public void setLocalizadorList(List<Localizador> localizadorList) {
        this.localizadorList = localizadorList;
    }

    public double getDescuentoTotalAplicado() {
        return descuentoTotalAplicado;
    }

    public void setDescuentoTotalAplicado(double descuentoTotalAplicado) {
        this.descuentoTotalAplicado = descuentoTotalAplicado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id=" + id +
                ", localizadorList=" + localizadorList +
                ", descuentoTotalAplicado=" + descuentoTotalAplicado +
                '}';
    }
}
