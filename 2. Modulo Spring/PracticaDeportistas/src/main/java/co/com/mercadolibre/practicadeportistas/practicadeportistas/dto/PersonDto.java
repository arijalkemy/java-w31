package co.com.mercadolibre.practicadeportistas.practicadeportistas.dto;


public class PersonDto {

    private String name, lastName;
    private int edad;
    private SportDto deporte;
    
    public PersonDto() {
    }

    public PersonDto(String name, String lastName, int edad, SportDto deporte) {
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
    public SportDto getDeporte() {
        return deporte;
    }
    public void setDeporte(SportDto deporte) {
        this.deporte = deporte;
    }

    
}
