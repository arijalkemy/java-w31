package com.bootcamp;

import com.bootcamp.objectsandclasses.Person;

public class Main {
    public static void main(String[] args) {
        executePersonExercise();
    }

    private static void executePersonExercise() {
        Person laura = new Person();
        Person lucas = new Person("lucas", 23, "12456321");
        Person carolina = new Person("carolina", 24, "12456321", 60, 1.62);

        int bmi = carolina.calculateBMI();
        boolean isAdult = carolina.isAdult();
        System.out.println(carolina);
        carolina.diagnoseBMI(bmi);

        if (isAdult){
            System.out.println("Is 18+");
        } else {
            System.out.println("Is not 18+");
        }
    }
}