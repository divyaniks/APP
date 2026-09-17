import java.util.Scanner;

class ExamActivity implements Runnable {
    private String activityName;
    private int interval;

    public ExamActivity(String activityName, int interval) {
        this.activityName = activityName;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + 
                                   " | Activity: " + activityName);
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class ExamSystemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sleep interval for Timer Thread (ms): ");
        int t1Time = scanner.nextInt();
        System.out.print("Enter sleep interval for Save Thread (ms): ");
        int t2Time = scanner.nextInt();
        System.out.print("Enter sleep interval for Network Thread (ms): ");
        int t3Time = scanner.nextInt();

        ExamActivity task1 = new ExamActivity("Displaying the remaining time", t1Time);
        ExamActivity task2 = new ExamActivity("Auto-saving the student's answers", t2Time);
        ExamActivity task3 = new ExamActivity("Checking the network connection", t3Time);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.setName("TimerThread");
        thread2.setName("SaveThread");
        thread3.setName("NetworkThread");

        thread1.start();
        thread2.start();
        thread3.start();

        scanner.close();
    }
}