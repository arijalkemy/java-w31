package bank.clients;

import bank.transactions.IBalanceCheck;
import bank.transactions.ICashWithdrawal;
import bank.transactions.IServicesPayment;

public class Basic implements IBalanceCheck, IServicesPayment, ICashWithdrawal {

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
    public void payService(String serviceType, Double amount) {
        System.out.println("Starting payment of $" + amount + ", for the service: " + serviceType + "...");
        checkTransaction("Services payment");
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
