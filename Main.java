package thread.work;

public class Main {


    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        BalanceDeposit balanceDeposit = new BalanceDeposit(bankAccount);
        BalanceWithdraw balanceWithdraw = new BalanceWithdraw(bankAccount);
        BalanceTransfer balanceTransfer = new BalanceTransfer(bankAccount);

        Thread thread1 = new Thread(balanceDeposit);
        Thread thread2 = new Thread(balanceWithdraw);
        Thread thread3 = new Thread(balanceTransfer);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}