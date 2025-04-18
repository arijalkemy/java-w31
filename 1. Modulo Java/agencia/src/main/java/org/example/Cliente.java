package org.example;

public class Cliente {
    private String nombre;
    private String id;
    private List<Localizador> historial = new ArrayList<>();

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void agregarLocalizador(Localizador l) {
        historial.add(l);
    }

    public List<Localizador> getHistorial() {
        return historial;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

