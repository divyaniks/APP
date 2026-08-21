import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= balance)
            balance -= amount;
        else
            System.out.println("Insufficient balance");
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class Bank{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Account Number: ");
        int no = sc.nextInt();

        System.out.print("Account Holder: ");
        String name = sc.next();

        System.out.print("Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount b = new BankAccount(no, name, balance);

        System.out.print("Deposit amount: ");
        b.deposit(sc.nextDouble());

        System.out.print("Withdraw amount: ");
        b.withdraw(sc.nextDouble());

        b.display();
    }
}