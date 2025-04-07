package ejercicio2;

import java.util.ArrayList;

public class Curriculum extends Documento{
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }


    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dni: " + dni);
        System.out.println("Edad: " + edad);
        for (String habilidad: habilidades) {
            System.out.println("Habilidad: " + habilidad);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }


    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}';
    }
}
