package com.bootcamp.objectsandclasses;

public class Person {
    String name;
    Integer age;
    String dni;
    Integer weight;
    Double height;

    public Person() {
    }

    public Person(String name, Integer age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, Integer age, String dni, Integer weight, Double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public Integer calculateBMI(){
        double bmi = weight / (height * height);
        if (bmi < 20) {
            return -1;
        } else if (bmi >= 20 && bmi <=25) {
            return 0;
        } else {
            return 1;
        }
    }

    public void diagnoseBMI(Integer bmi) {
        switch (bmi){
            case -1:
                System.out.println("With low weight");
                break;
            case 0:
                System.out.println("With healthy weight");
                break;
            case 1:
                System.out.println("Overweight");
                break;
            default:
                break;
        }
    }

    public boolean isAdult(){
        return age >= 18;
    }

    @Override
    public String toString(){
        return "Name: "+ name + ", Age: " + age + ", DNI: " + dni +
                ", Weight: " + weight + ", Height: " + height;
    }
}
