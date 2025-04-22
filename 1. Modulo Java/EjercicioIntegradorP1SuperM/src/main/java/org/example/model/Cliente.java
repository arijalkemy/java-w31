package org.example.model;

public class Cliente{
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(String dni, String nombre, String apellido){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public void setDni (String dni){
        this.dni=dni;
    }
    public void setNombre (String nombre){
        this.nombre=nombre;
    }
    public void setApellido (String apellido){
        this.apellido=apellido;
    }

    public String getDni(){
        return this.dni;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

}
