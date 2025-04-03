package com.bootcamp;

import com.bootcamp.exceptions.ExceptionsPractice;
import com.bootcamp.inheritance.NonPerishable;
import com.bootcamp.inheritance.Perishable;
import com.bootcamp.inheritance.Product;
import com.bootcamp.objectsandclasses.Person;

public class Main {
    public static void main(String[] args) {
        executePersonExercise();

        executeProductsExercise();

        executeExceptionsExercise();
    }

    private static void executeProductsExercise() {
        System.out.println("\n---Inheritance: Products---\n");
        Product product1 = new Perishable("apple", 2.5, 3);
        Product product2 = new Perishable("eggs", 5D, 2);
        Product product3 = new NonPerishable("beans", 1.2, "pantry");
        Product product4 = new NonPerishable("lentils", 1D, "pantry");
        Integer productAmount1 = 1, productAmount2 = 2, productAmount3 = 2, productAmount4 = 5;

        System.out.println(product1);
        System.out.println("Price for " + productAmount1 + " " + product1.getName() + ": $" + product1.calculate(productAmount1));
        System.out.println(product2);
        System.out.println("Price for " + productAmount2 + " " + product2.getName() + ": $" + product2.calculate(productAmount2));
        System.out.println(product3);
        System.out.println("Price for " + productAmount3 + " " + product3.getName() + ": $" + product3.calculate(productAmount3));
        System.out.println(product4);
        System.out.println("Price for " + productAmount4 + " " + product4.getName() + ": $" + product4.calculate(productAmount4));
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