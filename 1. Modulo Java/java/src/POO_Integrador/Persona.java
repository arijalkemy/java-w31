package POO_Integrador;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    //constructor defecto
    public Persona (){
    }

    //constructor con algunos parametros
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = 0.0;               // Valor por defecto
        this.altura = 0.0;             // Valor por defecto
    }

    //constructor con todos los parametros
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    // getters
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getDni() {
        return dni;
    }
    public double getPeso() {
        return peso;
    }
    public double getAltura() {
        return altura;
    }

    //calcular imc
    public int calcularIMC(){
        //validacion de altura
        if (this.altura <= 0) {
            return -1000;
        }
        double imc = peso / Math.pow(altura, 2);
        if (imc < 20) {
            return -1;  // peso insuficiente
        } else if (imc >= 20 && imc <= 25) {
            return 0;   // Peso normal
        } else {
            return 1;   // sobrepeso
        }
    }
    //evaluar si es mayor de edad
    public boolean esMayorDeEdad(){
        if (edad >= 18)
        {
            return true;
        } else {
            return false;
        }
    }

    // toString para mostrar la información de la persona
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Edad: " + edad +
                ", DNI: " + dni +
                ", Peso: " + peso + " kg" +
                ", Altura: " + altura + " m";
    }
}
