/**
 * File: UseCar.java
 * Description: Create three cars and display each car with its owner's name and address.
 * Date: 11/01/26
 * @author A. Alnusair (client structure), Tyler Bolander
 */

import java.util.ArrayList;

public class UseCar {

    public static void main(String[] args) {
        CarSystem carSystem = new CarSystem();
        carSystem.start();
    }
}

/** stores the cars and owners used in this example. */
class CarSystem {

    private ArrayList<Car> cars = new ArrayList<Car>();
    private ArrayList<CarOwner> owners = new ArrayList<CarOwner>();

    public void start() {
        // fill in the first owner's details using the setters
        CarOwner firstOwner = new CarOwner();
        firstOwner.setName("John Doe");
        firstOwner.setAddress("1312 Lakeside Street");
        owners.add(firstOwner);

        CarOwner secondOwner = createOwner("John Carter", "323 Ocean Avenue");
        createOwner("Jamie Reed", "922 Grove Street"); // This owner currently has no cars

        // set up the first car using the default constructor
        Car firstCar = new Car();
        firstCar.setMake("Chevrolet");
        firstCar.setModel("Malibu");
        firstCar.setYear(2017);
        firstCar.setPrice(12000);
        firstCar.setOwner(firstOwner);
        cars.add(firstCar);

        // John Doe owns both the Chevy and the Mazda
        cars.add(new Car("Mazda", "CX-5", 2019, 17500, firstOwner));
        cars.add(new Car("Subaru", "Outback", 2022, 24000, secondOwner));

        displayCars();

        System.out.println("Checking the first car through its getters:");
        System.out.println(firstCar.getYear() + " " + firstCar.getMake()
                + " " + firstCar.getModel());
        System.out.printf("Price: $%.2f%n", firstCar.getPrice());
        System.out.println("Owner: " + firstCar.getOwner().getName());
        System.out.println("Address: " + firstCar.getOwner().getAddress());

        // Jamie still shows here even though they have no cars
        System.out.println("\nAll owner records:");
        for (CarOwner owner : owners) {
            System.out.println(owner + "\n");
        }
    }

    /** creates an owner and saves them in the owners list */
    public CarOwner createOwner(String name, String address) {
        CarOwner owner = new CarOwner(name, address);
        owners.add(owner);
        return owner;
    }

    /** prints each car and its owner's details */
    public void displayCars() {
        System.out.println("Cars on record\n==============");
        for (Car car : cars) {
            System.out.println(car + "\n");
        }
    }
}
