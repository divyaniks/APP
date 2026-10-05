class OrderProcessing extends Thread {

    OrderProcessing() {
        setName("OrderProcessing");
        setPriority(Thread.MAX_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Processing customer order " + i
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class DeliveryTracking extends Thread {

    DeliveryTracking() {
        setName("DeliveryTracking");
        setPriority(Thread.NORM_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Tracking delivery location " + i
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Notification extends Thread {

    Notification() {
        setName("Notification");
        setPriority(Thread.MIN_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " | Priority: " + getPriority()
                + " | Sending order-status notification " + i
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class FoodDeliverySystem {

    public static void main(String[] args) {

        OrderProcessing order = new OrderProcessing();
        DeliveryTracking delivery = new DeliveryTracking();
        Notification notification = new Notification();

        order.start();
        delivery.start();
        notification.start();
    }
}