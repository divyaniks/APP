import java.util.Scanner;

class BankingActivity implements Runnable {
    private String activity;
    private int delay;

    public BankingActivity(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int count = 1; count <= 3; count++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() +
                                   " | Activity: " + activity +
                                   " | Execution Count: " + count);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class BankingApplicationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter delay for TxnProcessor (ms): ");
        int d1 = scanner.nextInt();
        System.out.print("Enter delay for Balancer (ms): ");
        int d2 = scanner.nextInt();
        System.out.print("Enter delay for Notifier (ms): ");
        int d3 = scanner.nextInt();

        Thread t1 = new Thread(new BankingActivity("Transaction Processing", d1));
        Thread t2 = new Thread(new BankingActivity("Balance Updating", d2));
        Thread t3 = new Thread(new BankingActivity("SMS Notification", d3));

        t1.setName("TxnProcessor");
        t2.setName("Balancer");
        t3.setName("Notifier");

        t1.start();
        t2.start();
        t3.start();

        scanner.close();
    }
}