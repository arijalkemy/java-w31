package com.mercadolibre.SaveTheRopa.resources.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa<T> {
    private Map<Integer, List<T>> prendas;
    private int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<T> listaPrenda) {
        contador++;
        prendas.put(contador, listaPrenda);
        return contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<T>> entry : prendas.entrySet()) {
            System.out.println("ID: " + entry.getKey());
            for (T prenda : entry.getValue()) {
                System.out.println(prenda);
            }
        }
    }

    public List<T> devolverPrendas(Integer numero) {
        return prendas.remove(numero);
    }

    public Map<Integer, List<T>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<T>> prendas) {
        this.prendas = prendas;
    }


    @Override
    public String toString() {
        return "GuardaRopa{" +
                "prendas=" + prendas +
                ", contador=" + contador +
                '}';
    }
}
