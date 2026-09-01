// Parent Class
class Vehicle {
    String vehicleNumber;
    String brand;
    int speed;

    // Constructor for Vehicle
    public Vehicle(String vehicleNumber, String brand, int speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    // Method to be overridden
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }
}

// Child Class: Car
class Car extends Vehicle {
    int numberOfDoors;

    // Constructor for Car
    public Car(String vehicleNumber, String brand, int speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed); // Calling parent constructor
        this.numberOfDoors = numberOfDoors;
    }

    // Overriding displayDetails()
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

// Child Class: Bike
class Bike extends Vehicle {
    boolean hasGear;

    // Constructor for Bike
    public Bike(String vehicleNumber, String brand, int speed, boolean hasGear) {
        super(vehicleNumber, brand, speed); // Calling parent constructor
        this.hasGear = hasGear;
    }

    // Overriding displayDetails()
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Has Gear: " + (hasGear ? "Yes" : "No"));
    }
}

// Main Class to demonstrate Runtime Polymorphism
public class Vehicles {
    public static void main(String[] args) {
        // Using a Vehicle reference to point to a Car object
        Vehicle myVehicle1 = new Car("CAR-1234", "Toyota", 180, 4);
       
        // Using a Vehicle reference to point to a Bike object
        Vehicle myVehicle2 = new Bike("BIKE-5678", "Yamaha", 120, true);

        System.out.println("--- Displaying Car Details via Vehicle Reference ---");
        // Invokes Car's overridden displayDetails() at runtime
        myVehicle1.displayDetails();

        System.out.println("\n--- Displaying Bike Details via Vehicle Reference ---");
        // Invokes Bike's overridden displayDetails() at runtime
        myVehicle2.displayDetails();
    }
}