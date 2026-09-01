interface BasicSecurity {
    void login();
    void logout();
}

interface AdvancedSecurity extends BasicSecurity {
    void fingerprintAuthentication();
    void faceRecognitionAuthentication();
}

class BankingApplication implements AdvancedSecurity {

    public void login() {
        System.out.println("User logged in successfully.");
    }

    public void logout() {
        System.out.println("User logged out successfully.");
    }

    public void fingerprintAuthentication() {
        System.out.println("Fingerprint authentication successful.");
    }

    public void faceRecognitionAuthentication() {
        System.out.println("Face recognition authentication successful.");
    }
}

public class MobileBanking {
    public static void main(String[] args) {

        BankingApplication bank = new BankingApplication();

        // Basic security operations
        bank.login();
        bank.logout();

        // Advanced security operations
        bank.fingerprintAuthentication();
        bank.faceRecognitionAuthentication();
    }
}