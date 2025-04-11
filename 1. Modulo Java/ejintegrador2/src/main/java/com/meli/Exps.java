package com.meli;

public class Exps extends Prototipo {
    private int incremento = 200; 
    // esto es un constructor super para que herede el valor de nivel
    public Exps(int experiencia) {
        super(experiencia);
        
    }
    @Override
    public int devolverSiguiente() {
        valorInicial+=incremento;
        return valorInicial;
    
}
    @Override
    public String toString() {
        return "Experiencia actual: " + valorInicial;
    }

}
