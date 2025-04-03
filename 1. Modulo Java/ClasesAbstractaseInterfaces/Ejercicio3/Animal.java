package ClasesAbstractaseInterfaces.Ejercicio3;

public abstract class Animal {
    private String nombre;
    private int edad;
    private String especie;
    private boolean comido;

    public Animal(String nombre, int edad, String especie) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.comido = false;
    }

    public void emitirSonido(){};

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEspecie() {
        return especie;
    }
    public boolean animalComido() {
        return comido;
    }
    public void comer() {
        this.comido = true;
    }
}
