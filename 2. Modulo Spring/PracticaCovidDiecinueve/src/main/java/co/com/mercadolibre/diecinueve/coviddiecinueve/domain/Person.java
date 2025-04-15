package co.com.mercadolibre.diecinueve.coviddiecinueve.domain;

public class Person {

    private Long id;
    private String name, lastName;
    private int age;
    private Symptom symptom;

    public Person() {
    }

    public Person(Long id, String name, String lastName, int age, Symptom symptom) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.symptom = symptom;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Symptom getSymptom() {
        return symptom;
    }
    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }
}
