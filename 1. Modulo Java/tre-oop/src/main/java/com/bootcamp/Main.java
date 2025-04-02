package com.bootcamp;

import com.bootcamp.exceptions.ExceptionsPractice;
import com.bootcamp.objectsandclasses.Person;

public class Main {
    public static void main(String[] args) {
        executePersonExercise();

        executeExceptionsExercise();
    }

    private static void executeExceptionsExercise() {
        System.out.println("\n---Exceptions---\n");
        ExceptionsPractice ex = new ExceptionsPractice();
        try {
            ex.calculateDivision();
        } catch (ArithmeticException e) {
            // System.out.println("An error has occurred");
            throw new IllegalArgumentException("Cannot divide by zero");
        } finally {
            System.out.println("Program ended");
        }
    }

    private static void executePersonExercise() {
        System.out.println("\n---Objects and Classes---\n");
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