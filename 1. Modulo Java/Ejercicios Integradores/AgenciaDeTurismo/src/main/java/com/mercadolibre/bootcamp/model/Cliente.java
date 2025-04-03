package com.mercadolibre.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private Boolean clienteHabitual;
    private List<Localizador> localizadores;


    public Cliente(Long id, String dni, String nombre, String apellido, String email) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.localizadores = new ArrayList<>();
    }

    public void adicionarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getClienteHabitual() {
        return clienteHabitual;
    }

    public void setClienteHabitual(Boolean clienteHabitual) {
        this.clienteHabitual = clienteHabitual;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", clienteHabitual=" + clienteHabitual +
                ", localizadores=" + localizadores +
                '}';
    }
}
