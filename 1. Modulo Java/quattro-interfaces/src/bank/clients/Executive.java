package bank.clients;

import bank.transactions.IDeposit;
import bank.transactions.ITransfer;

public class Executive implements IDeposit, ITransfer {

    @Override
    public void makeDeposit(Double amount) {
        System.out.println("Starting deposit of $" + amount + "...");
        checkTransaction("Deposit");
    }

    @Override
    public void makeTransfer(Double amount, String destination) {
        System.out.println("Starting transfer of $" + amount + ", to " + destination + "...");
        checkTransaction("Transfer");
    }

    @Override
    public void transactionOk(String transactionType) {
        System.out.println("The " + transactionType.toLowerCase() + " was successfully executed! :)");
    }

    @Override
    public void transactionNotOk(String transactionType) {
        System.out.println("The " + transactionType.toLowerCase() + " was not successfully executed :(");
    }
}
