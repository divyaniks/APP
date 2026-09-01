import account.Account;
import account.SavingsAccount;
import account.CurrentAccount;

import payment.Payment;
import payment.SecurePayment;
import payment.UPIPayment;
import payment.CardPayment;

import security.OnlineTransaction;

public class Mainfile {

    public static void main(String[] args) {

        // Runtime Polymorphism
        System.out.println("===== ACCOUNT DETAILS =====");

        Account account;

        account = new SavingsAccount(
            1001,
            "Rahul",
            50000,
            4.5
        );

        account.displayDetails();

        System.out.println();

        account = new CurrentAccount(
            1002,
            "Priya",
            75000,
            25000
        );

        account.displayDetails();

        // Payment demonstration
        System.out.println();
        System.out.println("===== PAYMENT DETAILS =====");

        Payment payment;

        // UPI Payment
        payment = new UPIPayment();
        payment.pay(2500);

        // Secure payment verification
        SecurePayment securePayment = new UPIPayment();
        securePayment.verifyPayment();
        securePayment.pay(1500);

        // Card Payment
        payment = new CardPayment();
        payment.pay(5000);

        // Tagging interface demonstration
        System.out.println();
        System.out.println("===== ONLINE TRANSACTION CHECK =====");

        OnlineTransaction transaction;

        transaction = new UPIPayment();

        if (transaction instanceof OnlineTransaction) {
            System.out.println("UPI is an online transaction.");
        }

        transaction = new CardPayment();

        if (transaction instanceof OnlineTransaction) {
            System.out.println("Card is an online transaction.");
        }
    }
}