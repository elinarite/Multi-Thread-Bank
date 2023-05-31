package thread.work;

public class BankAccount {
    private int depositAccount;
    private int giroAccount;
    int amount = 40;

    public BankAccount() {
    }

    public BankAccount(int depositAccount) {
        this.depositAccount = depositAccount;
    }

    public BankAccount(int depositAccount, int giroAccount) {

        this.depositAccount = depositAccount;
        this.giroAccount = giroAccount;
    }

    public synchronized void deposit(int count) {
        while (depositAccount > 150 | giroAccount > amount) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        depositAccount = depositAccount + amount;
        System.out.println(count + " Deposit: " + amount + ", new balances: " + depositAccount + ", giroAccount balance " + giroAccount);
        notifyAll();
    }

    public synchronized void transferDepositToGiro() {
        while (depositAccount < 150) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        giroAccount = depositAccount;
        System.out.printf("Your money has been transferred from deposit account %d to giro account%n", depositAccount);
        depositAccount = 0;
        notifyAll();
    }


    public synchronized void withdraw(int count) {
        while (giroAccount < amount) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        giroAccount = giroAccount - amount;
        System.out.println(count + " Withdraw: " + amount + ", new balances: " + giroAccount + ", balance deposit account " + depositAccount);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (giroAccount <= amount) notify();
    }
}