/**
 * File: Car.java
 * Description: Store a car's make, model, year, price, and owner.
 * Date: 10/27/26
 * @author Tyler Bolander
 */

public class Car {

    private String make;
    private String model;
    private int year;
    private double price;
    private CarOwner owner;

    /** Creates a car with default values that can be changed later. */
    public Car() {
        make = "Unknown";
        model = "Unknown";
        year = 0;
        price = 0;
        owner = new CarOwner();
    }

    /** Uses an owner created outside this class, so cars can share an owner. */
    public Car(String make, String model, int year, double price, CarOwner owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        if (owner == null) {
            this.owner = new CarOwner();
        } else {
            this.owner = owner;
        }
    }

    // Get and update the car's details.
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CarOwner getOwner() {
        return owner;
    }

    /** Changes the owner only when an owner object is supplied. */
    public void setOwner(CarOwner owner) {
        if (owner != null) {
            this.owner = owner;
        }
    }

    /** Includes the owner's info when a car is printed. */
    @Override
    public String toString() {
        return year + " " + make + " " + model
                + String.format("%nPrice: $%.2f", price)
                + "\nOwner: " + owner;
    }
}
