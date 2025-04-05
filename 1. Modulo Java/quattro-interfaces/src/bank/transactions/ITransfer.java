package bank.transactions;

public interface ITransfer extends ITransaction {
   public void makeTransfer(Double amount, String destination);
}
