package payment;

import security.OnlineTransaction;

public class CardPayment implements Payment, OnlineTransaction {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of ₹" + amount + " made using Card.");
    }
}