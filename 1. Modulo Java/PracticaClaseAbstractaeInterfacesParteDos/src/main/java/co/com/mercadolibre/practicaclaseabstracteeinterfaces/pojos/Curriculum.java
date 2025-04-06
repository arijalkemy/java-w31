package co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos;

public class Curriculum extends Document {

    private Person person;

    public Curriculum() {
    }

    public Curriculum(Person person) {
        this.person = person;
    }
    
    @Override
    public String toString() {
        return "Curriculum [person=" + person + "]";
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    
}
