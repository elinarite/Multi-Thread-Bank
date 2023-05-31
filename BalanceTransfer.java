package thread.work;

public class BalanceTransfer implements Runnable {
    private BankAccount bankAccount;
    public BalanceTransfer(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bankAccount.transferDepositToGiro();
        }
    }
}