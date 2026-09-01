package payment;

import security.OnlineTransaction;

public class UPIPayment implements SecurePayment, OnlineTransaction {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " made using UPI.");
    }

    @Override
    public void verifyPayment() {
        System.out.println("UPI payment verified successfully.");
    }
}
