package org.saveTheRopa.clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa<T>{
    private Integer contador;
    private Map<Integer, List<T>> prendasGuardadasList;

    public GuardaRopa() {
        this.contador = 0;
        this.prendasGuardadasList = new HashMap<>();
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Map<Integer, List<T>> getPrendasGuardadasList() {
        return prendasGuardadasList;
    }

    public void setPrendasGuardadasList(Map<Integer, List<T>> prendasGuardadasList) {
        this.prendasGuardadasList = prendasGuardadasList;
    }

    public Integer guardarPrendas(List<T> listaDePrenda) {

        this.contador++;
        this.prendasGuardadasList.put(this.contador, listaDePrenda);

        return this.contador;
    }

    public void mostrarPrendas() {
        for(Map.Entry<Integer, List<T>> entry : this.prendasGuardadasList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public List<T> devolverPrendas(Integer numero) {
        return prendasGuardadasList.get(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "contador=" + contador +
                ", map=" + prendasGuardadasList +
                '}';
    }
}
