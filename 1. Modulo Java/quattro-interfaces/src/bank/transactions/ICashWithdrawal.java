package bank.transactions;

public interface ICashWithdrawal extends ITransaction {
    public void withdrawCash(Double amount);
}
