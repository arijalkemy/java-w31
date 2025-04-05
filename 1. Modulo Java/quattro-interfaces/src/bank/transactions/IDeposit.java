package bank.transactions;

public interface IDeposit extends ITransaction {
    public void makeDeposit(Double amount);
}
