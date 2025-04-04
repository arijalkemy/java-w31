public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;


    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;

    }

    public Persona(String nombre, int edad, String dni) {
        this(nombre, edad, dni, 0.0, 0.0);
    }

    public Persona() {
        this("", 0, "", 0.0, 0.0);
    }

    public String getNombre() {
        return nombre;
    }
    public int calcularMC() {
        double imc = this.peso/Math.pow(this.altura, 2);
        if (imc < 20) {
            return  -1;
        }
        else if (imc >= 20 && imc <= 25) {
            return  0;
        }
        else {
            return  1;
        }
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String toString() {
        return "Nombre = " + nombre + "\nEdad = " + edad + " años" + "\nDNI=  " + dni + "\nPeso = " + peso + " kg"
                + "\nAltura = " + altura + " mt";
    }

}
