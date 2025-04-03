package com.company;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> guardaRopa;
    private Integer contador;


    public GuardaRopa(){
        this.guardaRopa = new HashMap<Integer, List<Prenda>>();
        this.contador = 0;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.contador ++;
        this.guardaRopa.put(this.contador,listaDePrenda);
        return this.contador;
    }
    public void mostrarPrendas(){
        guardaRopa.forEach((clave,valor)->System.out.println("Indice: " + clave + "\nLista de Ropa: " + valor));
    }

    public List<Prenda> devolverPrenda(Integer i){
        return guardaRopa.remove(i);
    }

}
