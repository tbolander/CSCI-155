/**
 * File: Car.java
 * Description: The make, model, VIN, year and owner are shared by both car types.
 * Date: 11/21/26
 * @author Tyler Bolander
 */

public abstract class Car {
    private String make;
    private String model;
    private int year;
    private String vin;
    private CarOwner owner;

    public Car(String make, String model, int year, String vin, CarOwner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("You must choose a car owner before saving the car!");
        }
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.owner = owner;
    }

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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public CarOwner getOwner() {
        return owner;
    }

    public void setOwner(CarOwner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("You must choose a car owner before saving the car!");
        }
        this.owner = owner;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + ", VIN " + vin + "\nOwner: " + owner;
    }
}
