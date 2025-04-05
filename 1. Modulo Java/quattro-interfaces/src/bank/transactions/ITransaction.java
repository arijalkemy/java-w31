package bank.transactions;

public interface ITransaction {
    public void transactionOk(String transactionType);
    public void transactionNotOk(String transactionType);

    default void checkTransaction(String transactionType) {
        int random = (int) (Math.random() * 2);
        if (random == 1) {
            transactionOk(transactionType);
        } else {
            transactionNotOk(transactionType);
        }
    }
}
