package Practica3;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){
    }

    public Persona (String nombre, int edad, String dni ){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona (String nombre, int edad, String dni , double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double cacularIMC(){
        if(this.peso != 0 && this.altura != 0){
            double resultado = this.peso/(Math.pow(this.altura, 2));
            if(resultado<20){
                return -1;
            }
            if(resultado >= 20 && resultado <=25){
                return 0;
            }
            return 1;
        }
        return -999; //esto es para los casos en el que no se haya seteado el peso y la altura
    }

    public boolean esMayorDeEdad(){
        return this.edad>=18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }


}



