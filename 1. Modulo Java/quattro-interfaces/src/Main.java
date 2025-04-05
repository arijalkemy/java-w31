import bank.clients.Basic;
import bank.clients.Collector;
import bank.clients.Executive;

public class Main {
    public static void main(String[] args) {
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