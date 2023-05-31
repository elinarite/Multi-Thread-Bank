package thread.work;

public class BalanceDeposit implements Runnable{

        private BankAccount bankAccount;

        public BalanceDeposit(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
               // int amount = (int) (Math.random() * 20) + 1;
                bankAccount.deposit(i);
            }
        }
    }