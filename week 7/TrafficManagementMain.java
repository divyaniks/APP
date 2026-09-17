import java.util.Scanner;

class TrafficJunctionThread extends Thread {
    private String trafficStatus;
    private int delay;

    public TrafficJunctionThread(String initialStatus, int delay) {
        this.trafficStatus = initialStatus;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Junction Thread: " + this.getName() + 
                                   " | Traffic Status: " + trafficStatus);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class TrafficManagementMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial status for Junction 1: ");
        String s1 = scanner.next();
        System.out.print("Enter monitoring frequency delay (ms) for Junction 1: ");
        int f1 = scanner.nextInt();

        System.out.print("Enter initial status for Junction 2: ");
        String s2 = scanner.next();
        System.out.print("Enter monitoring frequency delay (ms) for Junction 2: ");
        int f2 = scanner.nextInt();

        System.out.print("Enter initial status for Junction 3: ");
        String s3 = scanner.next();
        System.out.print("Enter monitoring frequency delay (ms) for Junction 3: ");
        int f3 = scanner.nextInt();

        TrafficJunctionThread junction1 = new TrafficJunctionThread(s1, f1);
        TrafficJunctionThread junction2 = new TrafficJunctionThread(s2, f2);
        TrafficJunctionThread junction3 = new TrafficJunctionThread(s3, f3);

        junction1.setName("North-Intersection");
        junction2.setName("South-Highway");
        junction3.setName("Downtown-Avenue");

        junction1.start();
        junction2.start();
        junction3.start();

        scanner.close();
    }
}