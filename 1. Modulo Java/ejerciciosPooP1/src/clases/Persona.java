public class Persona {
    //Ejercicio 1
    // variables de instancia (atributos)
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    //Ejercicio 2
    // metodos

    public Persona () {}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularMC() {
        double mc = peso/(altura*altura); // para castear puedo hacer int mc = (double) la cuenta

        if (mc < 20.0) return -1;
        else if (mc >= 20.0 || mc <= 25.0) return 0;

        return 1;

    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String toString() {
        return "Nombre: " + nombre + " \nEdad: " + edad + " \nDni: " + dni
                + " \nPeso: " + peso + " \nAltura: " + altura;
    }



}
