package com.meli.ejercicioabstractas.clases;

public abstract class Prototipo {
    Number serie;
    Number cantidadSucesion;

    public Number addNumbers(Number a, Number b) {
        if(a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        } else if(a instanceof Float || b instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if(a instanceof Long || b instanceof Long) {
            return a.longValue() + b.longValue();
        } else {
            return a.intValue() + b.intValue();
        }
    }

    public Number getCantidadSucesion() {
        return cantidadSucesion;
    }

    public void setCantidadSucesion(Number cantidadSucesion) {
        this.cantidadSucesion = cantidadSucesion;
    }

    public Number getSerie() {
        return serie;
    }

    public void setSerie(Number serie) {
        this.serie = serie;
    }


    public Prototipo(Number cantidadSucesion) {
        this.serie = cantidadSucesion;
        this.cantidadSucesion = cantidadSucesion;
    }
    public Number sucesivo(){
        serie = addNumbers(serie, cantidadSucesion);
        return serie;
    }
    public void reiniciarSerie(){
        serie = cantidadSucesion;
    }

    public void establecerInicio(Number num){
        serie = num;
    }
}
