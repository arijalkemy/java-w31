package com.mercadolibre.modulojava.ejerciciocircuitos;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Persona {
    private int numero_participante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numero_emergencia;
    private String rh;

    public Persona(int dni, String nombre, String apellido, int edad, String celular, String numero_emergencia, String rh) {
        this.numero_participante = Main.numerop;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.numero_emergencia = numero_emergencia;
        this.rh = rh;
        this.edad = edad;
        ++Main.numerop;
    }

    public int getEdad() {
        return this.edad;
    }

    public void inscribirPersona(Circuito categoria) {
        new Inscripcion(Main.numeroi, categoria, this);
    }

    public void mostrarinfo() {
        System.out.println("Numero de participante: " + this.numero_participante);
        System.out.println("DNI: " + this.dni);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
        System.out.println("Edad: " + this.edad);
        System.out.println("Celular: " + this.celular);
        System.out.println("Numero de emergencia: " + this.numero_emergencia);
        System.out.println("RH: " + this.rh);
        System.out.println();
    }
}
