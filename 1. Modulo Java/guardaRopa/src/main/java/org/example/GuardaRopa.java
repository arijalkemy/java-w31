package org.example;

import java.util.*;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendasGuardadas = new HashMap<>();
    private int contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        prendasGuardadas.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : prendasGuardadas.entrySet()) {
            System.out.println("Código " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendasGuardadas.remove(numero);
    }
}
