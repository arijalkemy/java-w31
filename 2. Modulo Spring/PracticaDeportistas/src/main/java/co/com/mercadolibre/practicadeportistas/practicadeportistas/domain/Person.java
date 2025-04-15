package co.com.mercadolibre.practicadeportistas.practicadeportistas.domain;


public class Person {

    private String name, lastName;
    private int edad;
    private Sport deporte;

    public Person() {
    }

    public Person(String name, String lastName, int edad, Sport deporte) {
        this.name = name;
        this.lastName = lastName;
        this.edad = edad;
        this.deporte = deporte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sport getDeporte() {
        return deporte;
    }

    public void setDeporte(Sport deporte) {
        this.deporte = deporte;
    }

    
}
