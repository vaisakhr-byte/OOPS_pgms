import java.lang.Math;
import java.time.Year;
import java.util.Scanner;

class Vehicle {
    String brand;
    String model;
    int year;
    double basePrice;
    int age;

    Vehicle(String brand, String model, int year, double basePrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
        this.age = Year.now().getValue() - year;
    }

    void displayInfo() {
        System.out.println("-----Basic Vehicle Info-----");
        System.out.println("The Brand is: " + brand);
        System.out.println("The Model is: " + model);
        System.out.println("The Year is: " + year);
        System.out.println("The Base Price is: INR " + basePrice);
    }

    double calculateResaleValue() {
        return basePrice * Math.pow(0.85, age);
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String brand, String model, int year, double basePrice, int numberOfDoors) {
        super(brand, model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    double calculateInsurance() {
        return (5000 * basePrice) + (1000 * numberOfDoors);
    }

    double calculateMaintenanceCost() {
        return (3000 * age) + (500 * numberOfDoors);
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Insurance: INR " + calculateInsurance());
        System.out.println("Maintenance Cost: INR " + calculateMaintenanceCost());
        System.out.println("Resale Value: INR " + calculateResaleValue());
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;

    Motorcycle(String brand, String model, int year, double basePrice, boolean hasSidecar) {
        super(brand, model, year, basePrice);
        this.hasSidecar = hasSidecar;
    }

    double calculateInsurance() {
        double insurance = 2500 * basePrice;
        if (hasSidecar)
            insurance += 1500;
        return insurance;
    }

    double calculateMaintenanceCost() {
        double maintenanceCost = 2000 * age;
        if (hasSidecar)
            maintenanceCost += 1000;
        return maintenanceCost;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Insurance: INR " + calculateInsurance());
        System.out.println("Maintenance Cost: INR " + calculateMaintenanceCost());
        System.out.println("Resale Value: INR " + calculateResaleValue());
    }
}

public class VEHICLE{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter details for Car:");
        System.out.print("Brand: ");
        String carBrand = sc.nextLine();
        System.out.print("Model: ");
        String carModel = sc.nextLine();
        System.out.print("Year: ");
        int carYear = sc.nextInt();
        System.out.print("Base Price: ");
        double carPrice = sc.nextDouble();
        System.out.print("Number of Doors: ");
        int doors = sc.nextInt();
        sc.nextLine();

        System.out.println("\nEnter details for Motorcycle:");
        System.out.print("Brand: ");
        String bikeBrand = sc.nextLine();
        System.out.print("Model: ");
        String bikeModel = sc.nextLine();
        System.out.print("Year: ");
        int bikeYear = sc.nextInt();
        System.out.print("Base Price: ");
        double bikePrice = sc.nextDouble();
        System.out.print("Has Sidecar (true/false): ");
        boolean hasSidecar = sc.nextBoolean();

        Car c = new Car(carBrand, carModel, carYear, carPrice, doors);
        Motorcycle m = new Motorcycle(bikeBrand, bikeModel, bikeYear, bikePrice, hasSidecar);

        System.out.println("\n-----Car Info-----");
        c.displayInfo();

        System.out.println("\n-----Motorcycle Info-----");
        m.displayInfo();


    }
}
