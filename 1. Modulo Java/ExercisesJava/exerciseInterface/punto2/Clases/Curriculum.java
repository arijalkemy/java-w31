package exerciseInterface.punto2.Clases;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Document {
    private String nombre;
    private int dni;
    private int edad;

    List listhabilidades = new ArrayList<>();

    public Curriculum(String nombre, int dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List getListhabilidades() {
        return listhabilidades;
    }

    public void setListhabilidades(ArrayList listhabilidades) {
        this.listhabilidades = listhabilidades;
    }

    @Override
    public void Imprimir() {
        System.out.println(" Nombre " + this.nombre + " dni " + this.dni + 
            " edad " + this.edad + " habilidades " + this.listhabilidades);
    }

    public void agregarhabilidad(String habilidad){
        listhabilidades.add(habilidad);
    }

    

    
}
