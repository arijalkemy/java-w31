package ejercicio_turismo.Model;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private Integer id;
    private ArrayList<Localizador> localizadores;

    public Cliente(String nombre, Integer id) {
        this.nombre = nombre;
        this.id = id;
        this.localizadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void addLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    public Integer getTotalLocalizadores() {
        return localizadores.size();
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", id=" + id + "]";
    }
}
