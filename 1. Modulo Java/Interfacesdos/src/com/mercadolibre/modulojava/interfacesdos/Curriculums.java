package com.mercadolibre.modulojava.interfacesdos;

import java.util.ArrayList;
import java.util.List;

public class Curriculums implements IImprimir {
    private String nombre;
    private String dni;
    private String telefono;
    private String email;
    private List<String> habilidades= new ArrayList<String>();
    public Curriculums(String nombre, String dni, String telefono, String email, List<String> habilidades) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.habilidades = habilidades;
    }
    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Telefono: " + telefono);
        System.out.println("Email: " + email);
        habilidades.forEach(System.out::println);
    }
}
