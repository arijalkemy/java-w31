package com.meli.ejercicioanimal;

import com.meli.ejercicioanimal.clases.Animal;
import com.meli.ejercicioanimal.clases.Gato;
import com.meli.ejercicioanimal.clases.Perro;
import com.meli.ejercicioanimal.clases.Vaca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        animales.add(perro);
        animales.add(gato);
        animales.add(vaca);

        animales.forEach( animal -> animal.comer());

    }
}
