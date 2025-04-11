package com.example;

public class Curriculum implements imprimir {
    private Persona persona;
    private Persona[] habilidades;
    
    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Persona[] habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum");
        System.out.println("Nombre: " +persona.getNombre());
        System.out.println("Apellido: " +persona.getApellidos());
        System.out.println("Habilidades: " + String.join(", ", persona.getHabilidades()));
        }
        
    }

