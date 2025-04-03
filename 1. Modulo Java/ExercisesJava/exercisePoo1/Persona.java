package exercisePoo1;

public class Persona {
    String name;
    int age;
    String dni;
    double weight;
    double height;

    // constructor sin parámetros
    public Persona() {

    }

    // constructor con algunos parámetros
    public Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    // constructor completo
    public Persona(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDni() {
        return dni;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    // métodos
    public double IMC(double weight, double height) {
        double imc = (weight / (Math.pow(height, 2)));

        if (imc < 20) {
            return -1;
        }
        if (imc > 20 && imc < 25) {
            return 0;
        }
        return 1;

    }

    public boolean isLegal() {
        return this.age > 18;
    }

    public String getDate() {
        return " Los datos de la persona son :  " + " nombre : " + this.name +
                " edad: " + this.age + " dni: " + this.dni + " peso: " + this.weight + " altura" +
                this.height;
    }

}
