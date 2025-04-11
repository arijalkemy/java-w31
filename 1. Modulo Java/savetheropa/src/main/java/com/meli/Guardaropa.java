package com.meli;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class Guardaropa {
    private Integer id;
    private Map<Integer, List<Prenda>> prendas;
    
    public Guardaropa(){
        this.id = 0;
        this.prendas = new HashMap<>();
    }
    
    public Integer guardarPrendas(List<Prenda> listadePrendas){
        prendas.put(id, listadePrendas);
           System.out.println("\nGuardar prendas");
           System.out.println("Id asignada para el guardado: " + id);
           return id++;
       }
    public void mostrarPredas(){
        System.out.println(prendas+ "\n");
    
    }
    public List<Prenda> devolverPrendas(Integer id){
        return prendas.get(id);
    }
    @Override
    public String toString() {
        return "GuardaRopa{" +
                "Diccionario=" + prendas+
                ", id=" + id +
                '}';
    }
}
