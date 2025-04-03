public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double altura;
    private double peso;

    public Persona() {}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double altura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public int calcularIMC(){
        double result = this.peso / Math.pow(this.altura, 2);
        return result < 20 ? -1 : result <= 25 ? 0 : 1;
    }

    public boolean esMayorDeEdad(){
        return this.edad > 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}