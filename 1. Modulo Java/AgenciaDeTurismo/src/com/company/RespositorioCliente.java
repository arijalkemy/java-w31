package com.company;

public class RespositorioCliente {
    private Localizador localizador;

    public RespositorioCliente(Localizador localizador) {
        this.localizador = localizador;
    }

    public Localizador getLocalizador() {
        return localizador;
    }

    public void setLocalizador(Localizador localizador) {
        this.localizador = localizador;
    }

    @Override
    public String toString() {
        return "RespositorioCliente{" +
                "localizador=" + localizador +
                '}';
    }

}
