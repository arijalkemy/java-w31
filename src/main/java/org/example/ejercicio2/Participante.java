package org.example.ejercicio2;

public class Participante {
    String nombre;
    String apellido;
    int dni;
    int edad;
    int telefono;
    int telefonoDeEmergencia;
    String grupoSanguineo;

    public Participante(String nombre, String apellido, int dni, int edad, int telefono, int telefonoDeEmergencia, String grupoSanguineo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.telefonoDeEmergencia = telefonoDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", edad=" + edad +
                ", telefono=" + telefono +
                ", telefonoDeEmergencia=" + telefonoDeEmergencia +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}


