package bank.clients;

import bank.transactions.IBalanceCheck;
import bank.transactions.ICashWithdrawal;

public class Collector implements ICashWithdrawal, IBalanceCheck {

    @Override
    public void checkBalance() {
        System.out.println("Starting balance check...");
        checkTransaction("Balance check");
    }

    @Override
    public void withdrawCash(Double amount) {
        System.out.println("Starting cash withdrawal of $" + amount + "...");
        checkTransaction("Cash withdrawal");
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
