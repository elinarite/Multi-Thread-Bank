package thread.work;

public class BalanceWithdraw implements Runnable {
    private BankAccount bankAccount;

    public BalanceWithdraw(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int amount = (int) (Math.random() * 40) + 1;
            bankAccount.withdraw(amount, i);
        }
    }
}