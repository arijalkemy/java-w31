package org.example.ejercicio2;

public class Categoria {
    TipoCategoria tipo;
    String categoriaNombre;
    int edadMinima;
    int costoMayores;
    int costoMenores;
    String[] terrenos;
    double largo;

    public Categoria(TipoCategoria tipo, String categoriaNombre, int costoMayores, int costoMenores, int edadMinima, String[] terrenos, double largo) {
        this.tipo = tipo;
        this.categoriaNombre = categoriaNombre;
        this.costoMayores = costoMayores;
        this.edadMinima = edadMinima;
        this.terrenos = terrenos;
        this.costoMenores = costoMenores;
        this.largo = largo;
    }

    public boolean admiteMenores() {
        return this.edadMinima < 18;
    }

}
