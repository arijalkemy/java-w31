package com.company;

import java.util.Arrays;

public class Curriculum implements ImprimirDocumento{
    private Persona p;
    private String [] habilidades;

    public Curriculum(Persona p, String[] habilidades) {
        this.p = p;
        this.habilidades = habilidades;
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Curriculum{" +
                "p=" + p.toString() +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}');
    }
}
