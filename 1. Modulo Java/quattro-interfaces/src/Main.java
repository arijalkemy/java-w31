import animals.Animal;
import animals.Cat;
import animals.Cow;
import animals.Dog;
import bank.clients.Basic;
import bank.clients.Collector;
import bank.clients.Executive;
import documents.Book;
import documents.Curriculum;
import documents.IPrintable;
import documents.Report;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        executeTransactionsExercise();

        executeDocumentsExercise();

        executeAnimalsExercise();
    }

    private static void executeAnimalsExercise() {
        System.out.println("\n---Executing Animals Exercise---");
        Cow cow = new Cow("Lola");
        Cat cat = new Cat("Sissy");
        Dog dog = new Dog("Francesco");
        cow.makeSound();
        cat.makeSound();
        dog.makeSound();

        cow.eatGrass();
        cat.eatMeat();
        dog.eatMeat();
    }

    private static void executeDocumentsExercise() {
        System.out.println("\n---Executing Documents Exercise---");
        Curriculum curriculum = new Curriculum("Laura", List.of("Python", "Java", "C#", "SQL"), List.of("Software Developer at Company X"));
        Book book = new Book("Gabriel García Márquez", "Cien años de soledad","Novel", 400);
        Report report = new Report("Report 1", "Carlos", "Pedro", "This is the report one", 5);
        printDocument(curriculum);
        printDocument(book);
        printDocument(report);
    }

    public static void printDocument(IPrintable printableDocument) {
        printableDocument.print();
    }

    private static void executeTransactionsExercise() {
        System.out.println("\n---Executing Transactions Exercise---");
        Executive executive = new Executive();
        executive.makeDeposit(21.5);
        executive.makeTransfer(5.2, "Savings account");
        System.out.println();

        Collector collector = new Collector();
        collector.checkBalance();
        collector.withdrawCash(50.0);
        System.out.println();

        Basic basic = new Basic();
        basic.payService("Gas", 12.5);
        basic.withdrawCash(13.0);
        basic.checkBalance();
    }
}