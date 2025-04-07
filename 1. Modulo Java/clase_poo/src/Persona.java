

public class Persona {
    
    String nombre;
    int edad;
    String dni;
    int peso;
    int altura;

    public Persona(){
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, int altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double alturaEnMetros = this.altura / 100.0;
        double imc = this.peso / (alturaEnMetros * alturaEnMetros);
        if(imc < 20){
            return -1;
        } else if(imc <= 25){
            return 0;
        } else {
            return 1;
        }
    }

    public Boolean esMayorDeEdad(){
        if (this.edad >= 18){
            return true;
        }
        return false;
    }

    public String toString(){
        return "Nombre: " + this.nombre + " Edad: " + this.edad + " DNI: " + this.dni +
        " Peso: " + this.peso + " Altura: " + this.altura;
    }
}
