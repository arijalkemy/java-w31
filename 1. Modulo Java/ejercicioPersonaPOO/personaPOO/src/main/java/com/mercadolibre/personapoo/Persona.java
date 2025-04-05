package main.java;

public class Persona {
    String nombre;
    int edad;
    String dni;
    float peso;
    float altura;
    //ejercicio 2
    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre =nombre;
        this.edad =edad;
        this.dni =dni;

    }
    public Persona(String nombre, int edad, String dni, float peso, float altura){
        this.nombre= nombre;
        this.edad= edad;
        this.dni =dni;
        this.peso = peso;
        this.altura = altura;
    }
    public int calcularIMC(){
        // podria usar (Math.pow(this.altura, 2))
        float IMC= this.peso/(this.altura* this.altura);
        if (IMC<20){
            return -1; // bajo peso
        }else if (20>= IMC && IMC <= 25){
            return 0;
        }else{
            return 1;
        }}
    public boolean esMayorDeEdad(){
        return(this.edad>=18);
    };

    public String toString(){
        return "nombre" + this.nombre + "edad" + this.edad + "dni" + this.dni + "peso" + this.peso + " kg, altura" + altura +"m.";
    };
}
