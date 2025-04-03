package com.mercadolibre;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> prendasGuardadas = new HashMap<>();
    private Integer contador = 0;

    public GuardaRopa() {
    }

    public HashMap<Integer, List<Prenda>> getPrendasGuardadas() {
        return prendasGuardadas;
    }

    public void setPrendasGuardadas(HashMap<Integer, List<Prenda>> prendasGuardadas) {
        this.prendasGuardadas = prendasGuardadas;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.contador++;
        this.prendasGuardadas.put(this.contador, listaDePrenda);
        System.out.println("Su numero para identificar es: " + this.contador);
        return this.contador;
    }

    public void mostrarPrendas() {
        if (this.prendasGuardadas.isEmpty()) {
            System.out.println("El guardaropa está vacio.");
        }
        for (Map.Entry<Integer, List<Prenda>> entrada : prendasGuardadas.entrySet()) {
            Integer numero = entrada.getKey();
            List<Prenda> listaPrendas = entrada.getValue();

            System.out.println("Número: " + numero);
            listaPrendas.stream().map(p -> " - Marca: " + p.getMarca() + ", Modelo: " + p.getModelo()).forEach(System.out::println);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        if (!this.prendasGuardadas.containsKey(numero)) {
            System.out.println("No existe ese identificador.");
            return Collections.emptyList();
        }

        List<Prenda> prendas = this.prendasGuardadas.get(numero);
        this.prendasGuardadas.remove(numero);
        System.out.println("Se han devuelto las prendas.");
        return prendas;
    }


}
