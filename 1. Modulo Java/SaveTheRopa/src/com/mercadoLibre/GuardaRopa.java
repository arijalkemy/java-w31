package com.mercadoLibre;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardarropas = new HashMap<>();
    private int contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        guardarropas.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        guardarropas.forEach((numero, prendas) -> {
            System.out.println("\nNúmero: " + numero);
            prendas.forEach(prenda -> System.out.println("  " + prenda));
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return guardarropas.getOrDefault(numero, Collections.emptyList());
    }
}
