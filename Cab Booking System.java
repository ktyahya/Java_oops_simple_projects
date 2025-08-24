import java.util.Scanner;

// Abstract Class (Abstraction)
abstract class Cab {
    private String driverName;
    private double baseFarePerKm;

    // Constructor
    public Cab(String driverName, double baseFarePerKm) {
        this.driverName = driverName;
        this.baseFarePerKm = baseFarePerKm;
    }

    // Encapsulation
    public String getDriverName() {
        return driverName;
    }

    public double getBaseFarePerKm() {
        return baseFarePerKm;
    }

    // Abstract Method (Polymorphism with overriding)
    public abstract double calculateFare(double distance);
}

// Inheritance
class MiniCab extends Cab {
    public MiniCab(String driverName) {
        super(driverName, 10.0); // base fare 10/km
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getBaseFarePerKm();
    }
}

class SedanCab extends Cab {
    public SedanCab(String driverName) {
        super(driverName, 15.0); // base fare 15/km
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getBaseFarePerKm() + 50; // additional charge
    }
}

class LuxuryCab extends Cab {
    public LuxuryCab(String driverName) {
        super(driverName, 25.0); // base fare 25/km
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getBaseFarePerKm() + 100; // luxury tax
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🚖 Welcome to OOP Cab Booking System 🚖");
        System.out.println("Choose Cab Type: 1. Mini  2. Sedan  3. Luxury");
        int choice = sc.nextInt();

        System.out.print("Enter distance (in km): ");
        double distance = sc.nextDouble();

        Cab cab = null;

        switch (choice) {
            case 1: cab = new MiniCab("Ramesh"); break;
            case 2: cab = new SedanCab("Suresh"); break;
            case 3: cab = new LuxuryCab("Mahesh"); break;
            default: System.out.println("Invalid choice!"); return;
        }

        double fare = cab.calculateFare(distance);
        System.out.println("\n✅ Booking Confirmed!");
        System.out.println("Driver: " + cab.getDriverName());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: ₹" + fare);
    }
}
