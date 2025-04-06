package co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos;

import co.com.mercadolibre.practicaclaseabstracteeinterfaces.enums.Skills;

public class Person {

    private String dni;
    private String fullName;
    private int yearsOfExperience;
    private Skills skills;
    private boolean bachelor;

    public Person(){

    }
    
    public Person(String dni, String fullName, int yearsOfExperience, Skills skills, boolean bachelor) {
        this.dni = dni;
        this.fullName = fullName;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = skills;
        this.bachelor = bachelor;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public Skills getSkills() {
        return skills;
    }
    public void setSkills(Skills skills) {
        this.skills = skills;
    }
    public boolean isBachelor() {
        return bachelor;
    }
    public void setBachelor(boolean bachelor) {
        this.
        
        bachelor = bachelor;
    }

    @Override
    public String toString() {
        return "Person [dni=" + dni + ", fullName=" + fullName + ", yearsOfExperience=" + yearsOfExperience
                + ", skills=" + skills + ", bachelor=" + bachelor + "]";
    }

    
    
}
