package com.company;

import java.util.*;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardaRopa;
    private int contador;

    public GuardaRopa(int contador ) {
        this.guardaRopa = new HashMap<>();
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        guardaRopa.put(contador, listaDePrenda);

        return contador++;
    }

    public void mostrarPrendas(){
        guardaRopa.forEach((id,prendas) -> {
            System.out.println("Clave: "+ id + " Prendas: "+ prendas);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){

        return guardaRopa.getOrDefault(numero, new ArrayList<>());
    }
}
