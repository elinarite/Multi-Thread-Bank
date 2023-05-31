package thread.work;

public class BankAccount {
    private int depositAccount;
    private int giroAccount;

    public BankAccount() {
    }

    public BankAccount(int depositAccount) {
        this.depositAccount = depositAccount;
    }

    public BankAccount(int depositAccount, int giroAccount) {

        this.depositAccount = depositAccount;
        this.giroAccount = giroAccount;
    }

    public synchronized void deposit(int amount, int count) {
        while (depositAccount > 150) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        depositAccount = depositAccount + amount;
      System.out.println(count + " Deposit: " + amount + ", new balances: " + depositAccount + ", giroAccount balance " + giroAccount);
        if (depositAccount < 150)
            notify();
    }

    public synchronized void transferDepositToGiro() {
       while (depositAccount <= 150) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        giroAccount = depositAccount;
       System.out.printf("Your money has been transferred from deposit account %d to giro account%n", depositAccount);
        if (depositAccount < 150)
            notify();
        depositAccount = 0;
    }


    public synchronized void withdraw(int amount, int count) {
        while (giroAccount < amount) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        giroAccount = giroAccount - amount;
        System.out.println(count + " Withdraw: " + amount + ", new balances: " + giroAccount + ", balance deposit account " + depositAccount);
        if (giroAccount < amount)
            notify();
    }
}