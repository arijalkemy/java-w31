import bank.clients.Basic;
import bank.clients.Collector;
import bank.clients.Executive;
import documents.Book;
import documents.Curriculum;
import documents.IPrintable;
import documents.Report;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        executeTransactionsExercise();

        executeDocumentsExercise();
    }

    private static void executeDocumentsExercise() {
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