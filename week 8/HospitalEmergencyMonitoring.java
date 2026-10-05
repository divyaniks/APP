class EmergencyAlert extends Thread {

    EmergencyAlert() {
        setName("EmergencyAlert");
        setPriority(Thread.MAX_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Critical alert monitoring"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class VitalMonitor extends Thread {

    VitalMonitor() {
        setName("VitalMonitor");
        setPriority(Thread.NORM_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Checking vital signs"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class ReportGenerator extends Thread {

    ReportGenerator() {
        setName("ReportGenerator");
        setPriority(Thread.MIN_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Preparing routine report"
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class HospitalEmergencyMonitoring {

    public static void main(String[] args) {

        EmergencyAlert emergency = new EmergencyAlert();
        VitalMonitor vital = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        emergency.start();
        vital.start();
        report.start();
    }
}