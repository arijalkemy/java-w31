package bank.transactions;

public interface IServicesPayment extends ITransaction {
    public void payService(String serviceType, Double amount);
}
