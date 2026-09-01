interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using UPI.");
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Net Banking.");
    }
}

public class OnlineShopping {
    public static void main(String[] args) {

        // Payment reference
        Payment payment;

        // Credit Card payment
        payment = new CreditCardPayment();
        payment.pay(2500.00);

        // UPI payment
        payment = new UPIPayment();
        payment.pay(1500.00);

        // Net Banking payment
        payment = new NetBankingPayment();
        payment.pay(3500.00);
    }
}