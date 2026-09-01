package payment;

public interface SecurePayment extends Payment {
    void verifyPayment();
}