package org.agencia_turismo.domain;

import java.util.List;
import java.util.Objects;

public class Cliente {
    private String nombre;
    private String apellido;
    private long id;
    private List<Localizador> localizadores;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, long id, List<Localizador> localizadores) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.localizadores = localizadores;
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

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void dtoAplicado() {
        int contBoletos = 0;
        int contReservas = 0;

        if(localizadores.size() >= 2) {
            System.out.println("Tendrás 5% de descuento en proximas reservas");
        };

        boolean flag = localizadores.stream().anyMatch(l -> l.getReserva().isCompleto());

        if(flag) {
            System.out.println("10% de descuento en total e factura");
        };

        for (Localizador l : localizadores) {
            Reserva reserva = l.getReserva();
            if (reserva != null) {
                if (reserva.getBoletosDeViaje()) {
                    contBoletos++;
                }
                if (reserva.getHotel()) {
                    contReservas++;
                }
            }

            if (contBoletos == 2 || contReservas == 2) {
                System.out.println("Se aplica descuento en reserva " + l.getReserva());
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id=" + id +
                ", localizadores=" + localizadores +
                '}';
    }
}
