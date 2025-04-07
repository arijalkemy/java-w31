package bootcamp.integrador_mañana;

import java.util.List;

public class Cliente {
    private String nombre;
    private int id;
    private List<Localizador> localizadores;

    public Cliente(String nombre, int id, List<Localizador> localizadores) {
        this.nombre = nombre;
        this.id = id;
        this.localizadores = localizadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", localizadores=" + localizadores +
                '}';
    }

    public void descuentoAplicado(){
        if ((localizadores.stream().anyMatch(l -> l.getReserva().isCompleto()))) {
            System.out.println("10% de descuento");
            return;
        }
        if(localizadores.size() >=2 && (localizadores.stream().filter(l -> l.getReserva().isBoletos()).count() >= 2)
            || localizadores.stream().filter(l -> l.getReserva().isHotel()).count() >= 2) {
            System.out.println("5% de descuento");
        }
    }
}
