package com.meli.ejercicioimpresora.clases;

import com.meli.ejercicioimpresora.interfaces.Documento;

import java.util.List;

public class Curriculum implements Documento {
    String persona;
    List<String> habilidades;

    public Curriculum(String persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println(persona + " Habilidades: " + habilidades);
    }
}
